package com.abhinay.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note


/**
 * Created by Abhinay on 28/01/25.
 *
 *
 */
@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao


}