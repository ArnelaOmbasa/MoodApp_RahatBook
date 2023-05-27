package com.example.moodapp.screens

import android.annotation.SuppressLint
import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moodapp.NewNoteDialog
import com.example.moodapp.Note
import com.example.moodapp.NotesList


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notes() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        contentAlignment = Alignment.Center
    ) {
        /*Text(
            text = "uspjela",
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )*/
        val notesList = remember { mutableStateListOf<Note>() }
        val showDialog = remember { mutableStateOf(false) }
        val title = remember { mutableStateOf("") }
        val description = remember { mutableStateOf("") }

        Scaffold(
            topBar = { TopAppBar(title = { Text("My Notes") }) },
            content = {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = "List of Notes")
                    Spacer(modifier = Modifier.height(16.dp))
                    NotesList(notesList)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            title.value = ""
                            description.value = ""
                            showDialog.value = true
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "+ Add New ")
                        Text(text = "New Note")
                    }
                }
            }
        )

        if (showDialog.value) {
            NewNoteDialog(
                title = title.value,
                onTitleChange = { title.value = it },
                description = description.value,
                onDescriptionChange = { description.value = it },
                onSaveClick = {
                    if (title.value.isNotBlank() && description.value.isNotBlank()) {
                        val newNote =
                            Note(title.value, description.value)
                        notesList.add(newNote)
                        saveNoteToSharedPreferences(newNote)
                        showDialog.value = false
                    }
                },
                onCancelClick = { showDialog.value = false }
            )
        }

    }



    }
fun saveNoteToSharedPreferences(note: Note) {
    // Save note to shared preferences here
    // You can use SharedPreferences API to save the note data
}


@Composable
@Preview
fun NotesScreenPreview() {
    Notes()
}