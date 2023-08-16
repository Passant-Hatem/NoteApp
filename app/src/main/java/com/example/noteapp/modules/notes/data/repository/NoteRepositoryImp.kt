package com.example.noteapp.modules.notes.data.repository


import com.example.noteapp.modules.notes.data.data_source.NoteDao
import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImp(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> = dao.getNotes()

    override suspend fun getNoteById(id: Int): Note? = dao.getNoteById(id)

    override suspend fun insertNote(note: Note) = dao.insertNote(note)

    override suspend fun deleteNote(note: Note) = dao.deleteNote(note)
}