package com.example.mynotes.Component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mynotes.Data.Note

@Composable
fun NotesRow(note: Note, onClick: (Note) -> Unit ){
    Surface(modifier = Modifier.padding(5.dp)
        .fillMaxWidth().clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp)),
        color = Color(0xB5B4C2CB),
    ){
        Column(modifier = Modifier.padding(10.dp).clickable { onClick(note) }) {
            Text(text = note.title)
            Text(text = note.description)
            Text(text = note.date.format("dd/MM/yyyy"))


        }
    }
}