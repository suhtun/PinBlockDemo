package com.su.pinblockdemo

import com.su.pinblockdemo.data.PinBlockUsecase
import com.su.pinblockdemo.data.PinBlockUsecaseImpl
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PinBlockUsecaseUnitTest {
    companion object{
        const val HEX_RADIX = 16
    }
    private val generatePin: PinBlockUsecase = PinBlockUsecaseImpl()

    @Test
    fun shortPin_isCorrect() {
        val shortPin = ""
        val pinBlock = generatePin.generatePinBlock(shortPin)
        assertEquals(true, pinBlock.isNullOrEmpty())
    }

    @Test
    fun longPin_isCorrect() {
        val longPin = "12345678901234567"
        val pinBlock = generatePin.generatePinBlock(longPin)
        assertEquals(true, pinBlock.isNullOrEmpty())
    }

    @Test
    fun pinBlock_isCorrect(){
        val pin = "1234"
        val pinBlock = generatePin.generatePinBlock(pin)
        assertEquals(true, pinBlock.length == HEX_RADIX)
    }
}