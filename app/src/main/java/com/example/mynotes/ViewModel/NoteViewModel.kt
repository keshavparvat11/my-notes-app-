package com.example.mynotes.ViewModel



import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.mynotes.Component.loadNotes
import com.example.mynotes.Data.Note

class NotesViewModel : ViewModel(){
    private val notes = mutableStateListOf<Note>()
    init {
        notes.addAll(loadNotes())
    }

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun removeNote(note: Note) {
        notes.remove(note)
    }
    fun getNotes(): List<Note> {
        return notes
    }
}