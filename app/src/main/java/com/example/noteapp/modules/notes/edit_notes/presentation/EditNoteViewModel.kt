package com.example.noteapp.modules.notes.edit_notes.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.modules.core.presentation.components.TransparentHintTextFieldState
import com.example.noteapp.modules.core.presentation.model.UiEvent
import com.example.noteapp.modules.notes.domain.model.InvalidNoteException
import com.example.noteapp.modules.notes.domain.model.Note
import com.example.noteapp.modules.notes.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private val _noteTitle = mutableStateOf(
        TransparentHintTextFieldState(
            hint = "Enter title..."
        )
    )
    val noteTitle: State<TransparentHintTextFieldState> = _noteTitle

    private val _noteContent = mutableStateOf(
        TransparentHintTextFieldState(
            hint = "Enter some content"
        )
    )
    val noteContent: State<TransparentHintTextFieldState> = _noteContent

    private val _noteColor = mutableStateOf(Note.noteColor.random().toArgb())
    val noteColor: State<Int> = _noteColor

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("id")?.let { noteId ->
            viewModelScope.launch {
                noteUseCases.getNote(noteId)?.also { note ->
                    currentNoteId = note.id
                    _noteTitle.value = noteTitle.value.copy(
                        text = note.title,
                        isHintVisible = false
                    )
                    _noteContent.value = _noteContent.value.copy(
                        text = note.content,
                        isHintVisible = false
                    )
                    _noteColor.value = note.color
                }
            }
        }
    }


    fun onEvent(event: EditNoteEvent) {
        when (event) {
            is EditNoteEvent.EnteredTitle -> {
                _noteTitle.value = noteTitle.value.copy(
                    text = event.value
                )
            }

            is EditNoteEvent.ChangeTitleFocus -> {
                _noteTitle.value = noteTitle.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            noteTitle.value.text.isBlank()
                )
            }

            is EditNoteEvent.EnteredContent -> {
                _noteContent.value = _noteContent.value.copy(
                    text = event.value
                )
            }

            is EditNoteEvent.ChangeContentFocus -> {
                _noteContent.value = _noteContent.value.copy(
                    isHintVisible = !event.focusState.isFocused &&
                            _noteContent.value.text.isBlank()
                )
            }

            is EditNoteEvent.ChangeColor -> {
                _noteColor.value = event.color
            }

            is EditNoteEvent.SaveNote -> {
                viewModelScope.launch {
                    try {
                        noteUseCases.addNote(
                            Note(
                                title = noteTitle.value.text,
                                content = noteContent.value.text,
                                timestamp = System.currentTimeMillis(),
                                color = noteColor.value,
                                id = currentNoteId
                            )
                        )
                        _eventFlow.emit(UiEvent.SaveNote)
                    } catch (e: InvalidNoteException) {
                        _eventFlow.emit(
                            UiEvent.ShowSnackBar(
                                message = e.message ?: "Couldn't save note"
                            )
                        )
                    }
                }
            }
        }
    }
}