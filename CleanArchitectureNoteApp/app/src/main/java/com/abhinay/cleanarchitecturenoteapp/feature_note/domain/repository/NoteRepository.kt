package com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository

import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


/**
 *  NoteRepository Interface
 *
 *  This interface defines the contract for interacting with the underlying data source
 *  for Note entities. It provides methods for retrieving, inserting, and deleting notes.
 *
 *  This interface abstracts the data access layer, allowing for different implementations
 *  (e.g., Room database, in-memory storage, network source) to be used interchangeably.
 *
 *  Methods:
 *    - `getNotes()`: Retrieves all notes from the data source as a reactive stream.
 *    - `getNoteById(id)`: Retrieves a specific note by its unique identifier.
 *    - `insertNote(note)`: Inserts a new note into the data source.
 *    - `deleteNote(note)`: Deletes an existing note from the data source.
 */
interface NoteRepository {

    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}