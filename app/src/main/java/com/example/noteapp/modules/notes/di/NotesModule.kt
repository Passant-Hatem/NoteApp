package com.example.noteapp.modules.notes.di

import com.example.noteapp.modules.notes.data.data_source.NoteDatabase
import com.example.noteapp.modules.notes.data.repository.NoteRepositoryImp
import com.example.noteapp.modules.notes.domain.repository.NoteRepository
import com.example.noteapp.modules.notes.domain.use_case.AddNote
import com.example.noteapp.modules.notes.domain.use_case.DeleteNote
import com.example.noteapp.modules.notes.domain.use_case.GetNote
import com.example.noteapp.modules.notes.domain.use_case.GetNotes
import com.example.noteapp.modules.notes.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object NotesModule {


    @Provides
    @ActivityRetainedScoped
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImp(database.noteDao)
    }

    @Provides
    @ActivityRetainedScoped
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }


}