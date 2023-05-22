package com.su.pinblockdemo.ui.pinblock

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.hilt.navigation.compose.hiltViewModel
import com.su.pinblockdemo.data.PinBlockUsecaseImpl.Companion.MAX_PIN_DIGIT_LENGTH
import com.su.pinblockdemo.R

@Composable
fun PinBlockScreen(modifier: Modifier = Modifier, viewModel: PinBlockScreeViewModel = hiltViewModel()) {

    Column(
        modifier = modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        PinBlock(value= viewModel.pinBlockValue.value)
        DigitPinInput(value = viewModel.pinValue.value, onValueChange = {viewModel.updatePinEntry(it)}, onImeAction = {viewModel.getPinBlock()})
    }
}

@Composable
fun PinBlock(value: String, modifier: Modifier = Modifier) {
    Text(
        text = "${stringResource(id = R.string.label_pin_block)} $value",
        modifier = modifier.padding(bottom = 20.dp, top = 40.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DigitPinInput(value: String, imeAction: ImeAction = ImeAction.Done, onImeAction: () -> Unit = {}, onValueChange :(String)-> Unit={}) {
    OutlinedTextField(
        value = value,
        onValueChange = {if(it.isDigitsOnly() && it.length<=MAX_PIN_DIGIT_LENGTH)onValueChange(it)},
        label = {
            Text(
                text = stringResource(id = R.string.enter_pin),
                style = MaterialTheme.typography.bodyMedium
            )
        },
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = imeAction,
            keyboardType = KeyboardType.NumberPassword
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
        })
    )
}
