package com.abhinay.cleanarchitecturenoteapp.feature_note.data.repository

import com.abhinay.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDao
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow


/**
 * Implementation of the [NoteRepository] interface.
 *
 * This class provides concrete implementations for interacting with note data
 * stored in a persistent data source using the provided [NoteDao].
 * It acts as an intermediary between the data source and the application's
 * higher-level components (e.g., Use Cases or ViewModels).
 *
 * @property dao The [NoteDao] used to access and manipulate note data.
 */
class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}