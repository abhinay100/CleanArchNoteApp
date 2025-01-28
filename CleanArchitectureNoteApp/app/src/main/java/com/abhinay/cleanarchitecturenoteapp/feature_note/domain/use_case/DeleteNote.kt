package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository


/**
 * Created by Abhinay on 28/01/25.
 *
 *
 */
class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }

}