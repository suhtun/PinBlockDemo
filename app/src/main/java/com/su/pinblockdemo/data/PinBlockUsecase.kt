package com.su.pinblockdemo.data

import com.su.pinblockdemo.data.PinBlockUsecaseImpl.Companion.PAN

interface PinBlockUsecase {
    fun generatePinBlock(pin:String, pan:String=PAN): String
}