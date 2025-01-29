package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.notes

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder


/**
 * Created by Abhinay on 29/01/25.
 *
 *
 */
sealed class NotesEvent {

    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}