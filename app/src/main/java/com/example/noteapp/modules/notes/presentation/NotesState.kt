package com.example.noteapp.modules.notes.presentation

import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.util.NoteOrder
import com.example.noteapp.modules.notes.domain.util.OrderType

data class NotesState (
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)