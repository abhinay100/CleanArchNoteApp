package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository


/**
 * Created by Abhinay on 30/01/25.
 *
 *
 */
/**
 * Use case for retrieving a specific note from the repository.
 *
 * This class follows the clean architecture principle by encapsulating
 * the logic for fetching a note by its ID.
 *
 * @property repository The repository handling note data operations.
 */
class GetNote(private val repository: NoteRepository) {

    /**
     * Retrieves a note from the repository by its unique ID.
     *
     * @param id The unique identifier of the note.
     * @return The corresponding Note object if found, otherwise null.
     */
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}