package com.su.pinblockdemo.data

import javax.inject.Singleton

@Singleton
class PinBlockUsecaseImpl: PinBlockUsecase {
    companion object{
        const val HEX_RADIX = 16
        const val MIN_PIN_DIGIT_LENGTH = 4
        const val MAX_PIN_DIGIT_LENGTH = 12
        const val PAN = "1111222233334444"
        const val RANDOM_PADDING_VALUES = "0123456789ABCDEF"
        const val ISO3_PAN_HEADER = "0000"
        const val ISO3_PAN_LENGTH = 12
        const val ISO3_HEADER = 3
        const val ISO_3_LENGTH = 16
    }

    override fun generatePinBlock(pindigit: String, pan: String): String {
        if(pindigit.length < MIN_PIN_DIGIT_LENGTH || pindigit.length> MAX_PIN_DIGIT_LENGTH) return ""

        val pinBlock = preparePin(pindigit)
        if(pinBlock == 0L) return ""

        val panBlock = preparePan(pan = pan)
        if(panBlock == 0L) return ""

        return pinBlock.xor(panBlock).toString(HEX_RADIX).uppercase()
    }

    private fun preparePin(pindigit:String): Long{
        val pinLenStr = pindigit.length.toString()
        val headerWithoutRandomPadding = "$ISO3_HEADER$pinLenStr$pindigit"

        val randomPaddingLen = ISO_3_LENGTH - headerWithoutRandomPadding.length
        val randomPaddingStringBuffer = StringBuffer()
        for(index in 0 until randomPaddingLen){
            randomPaddingStringBuffer.append(RANDOM_PADDING_VALUES.random())
        }

        val pinStr = headerWithoutRandomPadding + randomPaddingStringBuffer.toString()

        return pinStr.toLongOrNull(HEX_RADIX)?:0
    }

    private fun preparePan(pan: String): Long {
        val panStr = ISO3_PAN_HEADER +pan.substring(pan.length - ISO3_PAN_LENGTH)
        return panStr.toLongOrNull(HEX_RADIX)?:0
    }


}