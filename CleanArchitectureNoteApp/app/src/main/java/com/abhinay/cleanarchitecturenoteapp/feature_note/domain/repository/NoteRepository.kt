package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


/**
 * Created by Abhinay on 28/01/25.
 *
 *
 */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}