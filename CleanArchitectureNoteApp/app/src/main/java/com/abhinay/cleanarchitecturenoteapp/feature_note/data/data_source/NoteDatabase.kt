package com.abhinay.cleanarchitecturenoteapp.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.model.Note


/**
- * Created by Abhinay on 28/01/25.
- *
- *
+ * The NoteDatabase class represents the Room database for managing Note entities.
+ * It provides an access point to the underlying SQLite database and serves as
+ * the main access point for the application's persisted data.
 */
@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase : RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }


}