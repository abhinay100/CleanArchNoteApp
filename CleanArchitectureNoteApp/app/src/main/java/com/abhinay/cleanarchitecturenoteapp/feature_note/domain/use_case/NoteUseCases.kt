package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case


/**
 * `NoteUseCases` is a data class that encapsulates all the use cases related to notes.
 * It provides a central point of access for interacting with different note operations.
 *
 * This class serves as a composition root for note-related use cases, promoting separation of concerns
 * and making it easier to manage and inject dependencies.
 *
 * The class was initially created on 28/01/25 by Abhinay.
 *
 * @property getNotes Use case for retrieving a list of notes.
 * @property deleteNote Use case for deleting a specific note.
 * @property addNote Use case for adding a new note.
 * @property getNote Use case for retrieving a specific note by its identifier.
 */
data class NoteUseCases(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote,
    val getNote: GetNote
)