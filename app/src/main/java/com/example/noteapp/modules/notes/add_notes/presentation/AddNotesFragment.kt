package com.example.noteapp.modules.notes.add_notes.presentation

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
class AddNotesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AddEditNoteScreen(
                    noteColor = -1,
                    navigateBack = {findNavController().popBackStack()}
                )
            }
        }
    }

}