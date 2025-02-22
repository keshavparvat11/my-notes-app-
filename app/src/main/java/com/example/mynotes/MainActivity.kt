package com.example.mynotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mynotes.Screen.HomeScreenOfApp
import com.example.mynotes.ViewModel.NoteViewModel
import com.example.mynotes.ui.theme.MyNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyNotesTheme {
                val noteViewModel = viewModel<NoteViewModel>()
                NoteApp(noteViewModel)

            }
        }
    }
}


@Composable
fun NoteApp(notesViewModel: NoteViewModel){
    val notes = notesViewModel.noteList.collectAsState().value
    HomeScreenOfApp(notes =notes ,
        addNode = {notesViewModel.addNote(it)},
        removeNote = {notesViewModel.removeNote(it)})
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyNotesTheme {
        val noteViewModel = viewModel<NoteViewModel>()
         NoteApp(noteViewModel)
    }
}