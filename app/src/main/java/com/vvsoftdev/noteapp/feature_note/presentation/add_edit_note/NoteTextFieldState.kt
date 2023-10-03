package com.vvsoftdev.noteapp.feature_note.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = "",
    val hintTextId: Int = 0,
    val isHintVisible: Boolean = true
)
