package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository


/**
 * Created by Abhinay on 30/01/25.
 *
 *
 */
class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}