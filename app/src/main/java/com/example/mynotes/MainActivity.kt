package com.example.mynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Nullable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mynotes.Component.TextInput
import com.example.mynotes.Component.loadNotes
import com.example.mynotes.Screen.HomeScreenOfApp
import com.example.mynotes.ViewModel.NotesViewModel
import com.example.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNotesTheme {

                    NoteApp()

            }
        }
    }
}


@Composable
fun NoteApp(notesViewModel: NotesViewModel = NotesViewModel()){
    var notes = notesViewModel.getNotes()
    HomeScreenOfApp(notes =notes ,
        addNode = {notesViewModel.addNote(it)},
        removeNote = {notesViewModel.removeNote(it)})
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNotesTheme {
        NoteApp()
    }
}