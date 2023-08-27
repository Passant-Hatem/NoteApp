package com.example.noteapp.modules.notes.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.noteapp.modules.notes.edit_notes.presentation.NavigationParams
import com.example.noteapp.modules.notes.presentation.components.NotesScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotesFragment : Fragment() {

    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                NotesScreen(
                    onAddClicked = ::navigateToAddNotesFragment,
                    onNoteClicked = ::navigateToEditeNotesFragment
                )
            }
        }
    }

    private fun navigateToAddNotesFragment(){
        val action = NotesFragmentDirections.actionNotesFragmentToAddNotesFragment()
        findNavController().navigate(action)
    }

    private fun navigateToEditeNotesFragment(params: NavigationParams){
        val action = NotesFragmentDirections.actionNotesFragmentToEditNotesFragment(
            id = params.noteId,
            color = params.noteColor
        )
        findNavController().navigate(action)
    }
}