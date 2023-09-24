package com.example.noteapp.modules.notes.edit_notes.presentation

import androidx.compose.ui.focus.FocusState

sealed class EditNoteEvent{
    data class EnteredTitle(val value: String): EditNoteEvent()
    data class ChangeTitleFocus(val focusState: FocusState): EditNoteEvent()
    data class EnteredContent(val value: String): EditNoteEvent()
    data class ChangeContentFocus(val focusState: FocusState): EditNoteEvent()
    data class ChangeColor(val color: Int): EditNoteEvent()
    object SaveNote: EditNoteEvent()
}
