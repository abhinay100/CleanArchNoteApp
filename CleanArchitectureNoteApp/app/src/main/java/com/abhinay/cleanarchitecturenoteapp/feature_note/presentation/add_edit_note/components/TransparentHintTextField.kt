package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle


/**
 * A composable function that creates a text field with a transparent hint.
 * The hint is displayed when the text field is empty and not in focus.
 *
 * @param text The current text value of the text field.
 * @param hint The hint text to display when the text field is empty and not in focus.
 * @param modifier The modifier to be applied to the text field.
 * @param isHintVisible A boolean indicating whether the hint should be visible.
 *                      Usually determined by checking if the text is empty AND the field is not in focus. Defaults to true.
 * @param onValueChange A callback that is triggered when the text value changes. It receives the new text value.
 * @param textStyle The style to be applied to both the text field's content and the hint text. Defaults to the default text style.
 * @param singleLine A boolean indicating whether the text field should be limited to a single line. Defaults to false.
 * @param onFocusChange A callback that is triggered when the focus state of the text field changes. It receives the new focus state.
 *
 * Example usage:
 * ```kotlin
 * var text by remember { mutableStateOf("") }
 * var isHintVisible by remember { mutableStateOf(true) }
 * var isFocused by remember { mutableStateOf(false) }
 *
 * TransparentHintTextField(
 *     text = text,
 *     hint = "Enter your text here",
 *     modifier = Modifier.padding(16.dp),
 *     isHintVisible = isHintVisible,
 *     onValueChange = {
 *         text = it
 *         isHintVisible = it.isEmpty() && !isFocused
 *     },
 *     onFocusChange = {
 *         isFocused = it.isFocused
 *         is */
@Composable
fun TransparentHintTextField(
    text: String,
    hint: String,
    modifier: Modifier = Modifier,
    isHintVisible: Boolean = true,
    onValueChange: (String) -> Unit,
    textStyle: TextStyle = TextStyle(),
    singleLine: Boolean = false,
    testTag:String = "",
    onFocusChange: (FocusState) -> Unit
) {
    Box(
        modifier = modifier
    ) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            singleLine = singleLine,
            textStyle = textStyle,
            modifier = Modifier
                .testTag(testTag)
                .fillMaxWidth()
                .onFocusChanged {
                    onFocusChange(it)
                }
        )
        if(isHintVisible) {
            Text(text = hint, style = textStyle, color = Color.DarkGray)
        }
    }
}