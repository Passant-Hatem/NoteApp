package com.example.noteapp.modules.core.presentation.model

sealed class UiEvent {
    data class ShowSnackBar(val message: String): UiEvent()
    object SaveNote: UiEvent()
}