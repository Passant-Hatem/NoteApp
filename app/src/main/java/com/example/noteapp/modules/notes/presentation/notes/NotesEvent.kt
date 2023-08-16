package com.example.noteapp.modules.notes.presentation.notes

import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}