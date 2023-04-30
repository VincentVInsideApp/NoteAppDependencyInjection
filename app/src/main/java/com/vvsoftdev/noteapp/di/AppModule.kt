package com.vvsoftdev.noteapp.di

import androidx.room.Room
import com.vvsoftdev.noteapp.feature_note.data.data_source.NoteDatabase
import com.vvsoftdev.noteapp.feature_note.domain.repository.NoteRepository
import com.vvsoftdev.noteapp.feature_note.domain.repository.NoteRepositoryImpl
import com.vvsoftdev.noteapp.feature_note.domain.usecase.*
import com.vvsoftdev.noteapp.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.vvsoftdev.noteapp.feature_note.presentation.notes.NotesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // room database
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java, NoteDatabase.DATABASE_NAME
        ).build()
    }
    single { get<NoteDatabase>().noteDao }

    // repository
    single<NoteRepository> { NoteRepositoryImpl(get()) }

    // usecase
    single { NoteUseCases(
            getNote = GetNote(get()),
            getNotes = GetNotes(get()),
            deleteNote = DeleteNote(get()),
            addNote = AddNote(get())
        )
    }

    // viewModels
    viewModel { NotesViewModel(get())}

    viewModel { AddEditNoteViewModel(get(), get()) }


}