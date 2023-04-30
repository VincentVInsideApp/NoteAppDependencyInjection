package com.vvsoftdev.noteapp.feature_note.presentation.notes

import com.vvsoftdev.noteapp.feature_note.domain.model.Note
import com.vvsoftdev.noteapp.feature_note.domain.util.NoteOrder
import com.vvsoftdev.noteapp.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
