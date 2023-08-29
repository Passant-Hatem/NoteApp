package com.example.noteapp.modules.notes.edit_notes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.noteapp.modules.notes.presentation.add_edit_note.AddEditNoteScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditNotesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            val noteId = arguments?.getInt("id")
            val noteColor = arguments?.getInt("color")
            setContent {
                AddEditNoteScreen(
                    navigateBack = {findNavController().popBackStack()}
                )
            }
        }
    }

}
data class NavigationParams(
    val noteId: Int,
    val noteColor: Int
)