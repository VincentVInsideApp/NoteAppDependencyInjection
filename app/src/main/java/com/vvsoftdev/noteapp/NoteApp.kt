package com.vvsoftdev.noteapp

import android.app.Application
import com.vvsoftdev.noteapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class NoteApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin{
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@NoteApp)
            // Load modules
            modules(appModule)
        }
    }
}