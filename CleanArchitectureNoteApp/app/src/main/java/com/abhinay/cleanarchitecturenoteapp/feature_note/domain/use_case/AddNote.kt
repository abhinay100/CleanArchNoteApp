package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws


/**
 * Represents a use case for adding a new note.
 *
 * This class handles the logic for inserting a new note into the repository,
 * including validation of the note's title and content.
 *
 * @property repository The [NoteRepository] used to persist the note.
 * @constructor Creates an AddNote instance with the specified [NoteRepository].
 */
class AddNote(

    private val repository: NoteRepository

) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {

        if (note.title.isBlank()) {
            throw InvalidNoteException("The title of the note can't be empty.")

        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content of the note can't be empty.")

        }
        repository.insertNote(note)

    }
}