package com.abhinay.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.*
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow


/**
 * Data Access Object (DAO) for managing database operations on the `Note` entity.
 * Provides methods to retrieve, insert, and delete notes using Room persistence library.
 */
@Dao
interface NoteDao {

    /**
     * Retrieves all notes from the database as a Flow.
     * This allows real-time updates whenever the data changes.
     *
     * @return A Flow that emits a list of notes whenever there is a change.
     */
    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    /**
     * Retrieves a specific note by its ID.
     *
     * @param id The unique identifier of the note.
     * @return The corresponding Note object if found, otherwise null.
     */
    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteById(id: Int): Note?

    /**
     * Inserts a note into the database.
     * If the note already exists (based on its primary key), it will be replaced.
     *
     * @param note The note to be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    /**
     * Deletes a note from the database.
     *
     * @param note The note to be deleted.
     */
    @Delete
    suspend fun deleteNote(note: Note)
}
