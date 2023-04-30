package com.vvsoftdev.noteapp.feature_note.domain.usecase

import com.vvsoftdev.noteapp.feature_note.domain.model.Note
import com.vvsoftdev.noteapp.feature_note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}