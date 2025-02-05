package com.abhinay.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.abhinay.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.abhinay.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImpl
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.AddNote
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.DeleteNote
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNote
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.GetNotes
import com.abhinay.cleanarchitecturenoteapp.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * AppModule: A Dagger Hilt module responsible for providing application-wide dependencies.
 *
 * This module is installed in the SingletonComponent scope, meaning its provided
 * dependencies will have a single instance throughout the application's lifecycle.
 * It provides dependencies related to the note-taking feature, including the
 * Room database, the repository, and the use cases.
 *
 * Created by Abhinay on 28/01/25.
 */
@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            NoteDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUsecases(repository: NoteRepository): NoteUseCases {

        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)

        )

    }

}