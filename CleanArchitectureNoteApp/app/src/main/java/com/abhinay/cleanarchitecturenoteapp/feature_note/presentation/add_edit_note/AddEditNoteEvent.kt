package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.add_edit_note

import androidx.compose.ui.focus.FocusState


/**
 * Represents events that can occur within the Add/Edit Note screen.
 * This sealed class provides a type-safe way to handle different user interactions
 * and state changes related to creating or modifying a note.
 */
sealed class AddEditNoteEvent {

    data class EnteredTitle(val value: String) : AddEditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class EnteredContent(val value: String) : AddEditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddEditNoteEvent()
    data class ChangeColor(val color: Int) : AddEditNoteEvent()
    object SaveNote : AddEditNoteEvent()

}

