package com.example.mynotes.Component

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ButtonForSsave(save: () -> Unit) {
    Button(onClick = {
        save()
    }
    ){
        Text(text = "Save")
    }

}