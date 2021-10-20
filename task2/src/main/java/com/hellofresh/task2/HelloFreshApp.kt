package com.hellofresh.task2

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HelloFreshApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}