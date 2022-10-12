package com.example.noteapp.feature_note.domain.use_case

import com.example.noteapp.feature_note.data.rpository.FakeNoteRepository
import com.example.noteapp.feature_note.domain.model.InvalidNoteException
import com.example.noteapp.feature_note.domain.model.Note
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AddNoteTest {
    private lateinit var addNote: AddNote
    private lateinit var fakeNoteRepository: FakeNoteRepository

    @Before
    fun setUP() {
        fakeNoteRepository = FakeNoteRepository()
        addNote = AddNote(fakeNoteRepository)
    }

    @Test(expected = InvalidNoteException::class)
    fun `add empty title note`() {
        val note = Note(
            title = "",
            content = "blah blah blah",
            timestamp = 1,
            color = 1
        )
        runBlocking {
            addNote(note)
        }
    }

    @Test(expected = InvalidNoteException::class)
    fun `add empty content note`() {
        val note = Note(
            title = "blah blah blah",
            content = "",
            timestamp = 1,
            color = 1
        )
        runBlocking {
            addNote(note)
        }
    }
}