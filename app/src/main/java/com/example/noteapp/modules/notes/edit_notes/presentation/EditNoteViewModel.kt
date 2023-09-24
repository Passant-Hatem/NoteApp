package com.example.noteapp.modules.notes.edit_notes.presentation

import androidx.lifecycle.ViewModel
import com.example.noteapp.modules.notes.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    val useCases: NoteUseCases
) : ViewModel() {
}