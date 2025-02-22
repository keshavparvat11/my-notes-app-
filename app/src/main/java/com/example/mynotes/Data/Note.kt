package com.example.mynotes.Data




import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Calendar

import java.util.Date
import java.util.Locale

import java.util.UUID
@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_title")
    val title: String,
    @ColumnInfo(name = "note_description")
    val description: String,
    @ColumnInfo(name = "note_entry_date")
    val date : String = getCurrentFormattedDate()
)

fun getCurrentFormattedDate(): String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("EEE ,d MMM", Locale.getDefault())
    return dateFormat.format(calendar.time)
}