package com.example.noteapp.modules.notes.add_notes.presentation

import androidx.lifecycle.ViewModel
import com.example.noteapp.modules.notes.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
) : ViewModel() {

}