package com.example.noteapp.modules.notes.domain.use_case

import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note?{
        return repository.getNoteById(id)
    }

}