package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.OrderType


/**
 * A composable function that displays a section for ordering notes.
 *
 * This function provides radio buttons to select the ordering criteria (Title, Date, Color)
 * and the order type (Ascending, Descending). It allows the user to change the note order
 * and notifies the parent composable via a callback.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param noteOrder The current [NoteOrder] applied to the notes. Defaults to [NoteOrder.Date] with [OrderType.Descending].
 * @param onOrderChange A callback function that is invoked when the user changes the note order.
 *                      It receives the new [NoteOrder] as a parameter.
 *
 * Example Usage:
 * ```
 * OrderSection(
 *     noteOrder = myCurrentNoteOrder,
 *     onOrderChange = { newOrder ->
 *         // Update the note list with the new order
 *         myCurrentNoteOrder = newOrder
 *         // ... refresh the list of notes
 *     }
 * )
 * ```
 *
 * Created by Abhinay on 29/01/25.
 */
@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {

    Column(
        modifier = modifier
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChange(NoteOrder.Title(noteOrder.orderType)) }

            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChange(NoteOrder.Date(noteOrder.orderType)) }

            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChange(NoteOrder.Color(noteOrder.orderType)) }

            )

        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            DefaultRadioButton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }

            )

            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChange(noteOrder.copy(OrderType.Descending)) }

            )

        }

    }

}