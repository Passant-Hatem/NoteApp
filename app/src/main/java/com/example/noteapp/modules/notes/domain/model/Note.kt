package com.example.noteapp.modules.notes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteapp.modules.core.presentation.theme.BabyBlue
import com.example.noteapp.modules.core.presentation.theme.LightGreen
import com.example.noteapp.modules.core.presentation.theme.RedOrange
import com.example.noteapp.modules.core.presentation.theme.RedPink
import com.example.noteapp.modules.core.presentation.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColor = listOf(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
}

class InvalidNoteException(message: String) : Exception(message)
