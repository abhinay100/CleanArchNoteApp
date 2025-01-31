package com.abhinay.cleanarchitecturenoteapp.feature_note.presentation.util


/**
 * Created by Abhinay on 31/01/25.
 *
 *
 */
sealed class Screen(val route: String) {
    object NotesScreen : Screen("notes_screen")
    object AddEditNoteScreen : Screen("add_edit_note_screen")
}