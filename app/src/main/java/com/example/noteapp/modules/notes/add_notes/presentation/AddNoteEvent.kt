package com.example.noteapp.modules.notes.add_notes.presentation

import androidx.compose.ui.focus.FocusState

sealed class AddNoteEvent {
    data class EnteredTitle(val value: String) : AddNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState) : AddNoteEvent()
    data class EnteredContent(val value: String) : AddNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState) : AddNoteEvent()
    data class ChangeColor(val color: Int) : AddNoteEvent()
    object SaveNote : AddNoteEvent()
}