package com.example.noteapp.modules.notes.domain.use_case

import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
){
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}