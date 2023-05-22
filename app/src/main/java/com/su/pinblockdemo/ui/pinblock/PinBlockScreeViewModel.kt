package com.su.pinblockdemo.ui.pinblock

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.su.pinblockdemo.data.PinBlockUsecase
import com.su.pinblockdemo.data.PinBlockUsecaseImpl.Companion.PAN
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PinBlockScreeViewModel @Inject constructor(val pinBlockUserCase: PinBlockUsecase) : ViewModel() {

    private val _pinValue = mutableStateOf("")
    val pinValue = _pinValue

    private val _pinBlockValue = mutableStateOf("")
    val pinBlockValue = _pinBlockValue

    fun updatePinEntry(input: String) {
        viewModelScope.launch {
            _pinValue.value = input
        }
    }

    fun getPinBlock() {
        viewModelScope.launch {
            _pinBlockValue.value = pinBlockUserCase.generatePinBlock(_pinValue.value, PAN)
        }
    }

}