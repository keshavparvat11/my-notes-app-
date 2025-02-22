package com.example.mynotes.Screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mynotes.Component.ButtonForSsave
import com.example.mynotes.Component.NotesRow
import com.example.mynotes.Data.Note
import com.example.mynotes.Component.TextInput


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenOfApp(
    notes : List<Note>,
    addNode: (Note) -> Unit,
    removeNote: (Note) -> Unit

){
    var tile by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var context = LocalContext.current
    Column {
        TopAppBar(
            title = {
                Row {
                    Text(text = "Notes App")
                    Spacer(Modifier.width(240.dp))
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = "Notification"
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xFF608AA1)),
            modifier = Modifier.padding(5.dp)
        )
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,) {
            TextInput(title = "Title",
                value = tile,
                onValueChange = {tile = it},
                onTextChange = {})
            TextInput(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),title = "Description",
                value = description,
                onValueChange = {description = it},
                onTextChange = {})
            ButtonForSsave(){
                addNode(Note(title = tile, description = description))
                tile =""
                description = ""
                Toast.makeText(context, "Note Added", Toast.LENGTH_SHORT).show()
            }
            Divider()


        }
        if (notes.isEmpty()) {
            Text(text = "No Notes Available", modifier = Modifier.padding(16.dp))
        }
        else{
        LazyColumn {
            items(notes.size){
                NotesRow(note = notes[notes.size - 1 - it],removeNote)
            }
        }
}
    }
}
//@Composable
//@Preview(showBackground = true)
//fun DefaultPreview(){
//    HomeScreenOfApp(loadNotes(), {}, {})
//}