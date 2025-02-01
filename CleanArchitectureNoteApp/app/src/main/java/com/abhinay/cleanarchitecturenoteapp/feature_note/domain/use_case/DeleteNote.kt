package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository


/**
 * Created by Abhinay on 28/01/25.
 *
 *
 */
/**
 * Use case for deleting a note from the repository.
 *
 * This class encapsulates the logic for removing a note from the database,
 * making it part of a clean architecture approach.
 *
 * @property repository The repository handling note data operations.
 */
class DeleteNote(private val repository: NoteRepository) {

    /**
     * Deletes the given note from the repository.
     *
     * @param note The note to be deleted.
     */
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}