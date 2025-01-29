package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.OrderType


/**
 * Represents the state of the notes within the application.
 * This data class holds the list of notes, the current sorting order, and
 * the visibility state of the order section.
 *
 * @property notes The list of notes currently being displayed. Defaults to an empty list.
 * @property noteOrder The current order in which the notes are being displayed (e.g., by date, title).
 *                      Defaults to sorting by date in descending order.
 * @property isOrderSectionVisible A boolean indicating whether the section for selecting the note order is currently visible.
 *                                Defaults to `false` (hidden).
 */
data class NotesState(

    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
