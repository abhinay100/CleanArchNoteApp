package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/**
 * A styled RadioButton with accompanying text.
 *
 * This composable provides a RadioButton with a label, ensuring consistent styling
 * and behavior within the application. It handles the visual state of the RadioButton
 * based on the `selected` parameter and invokes the `onSelect` callback when clicked.
 *
 * @param text The text label to display alongside the RadioButton.
 * @param selected Whether the RadioButton is currently selected.
 * @param onSelect Callback invoked when the RadioButton is clicked.
 *                 This function should handle updating the selection state.
 * @param modifier Modifier to be applied to the container Row.
 */
@Composable
fun DefaultRadioButton(
    text: String,
    selected: Boolean,
    onSelect: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {

        RadioButton(
            selected = selected,
            onClick = onSelect,
            colors = RadioButtonDefaults.colors(
                selectedColor = MaterialTheme.colors.primary,
                unselectedColor = MaterialTheme.colors.onBackground
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.body1)

    }
}