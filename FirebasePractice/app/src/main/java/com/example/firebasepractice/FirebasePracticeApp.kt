package com.example.firebasepractice

import android.app.Application
import android.content.Context

class FirebasePracticeApp : Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}