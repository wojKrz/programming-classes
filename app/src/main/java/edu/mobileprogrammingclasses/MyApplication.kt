package edu.mobileprogrammingclasses

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import edu.mobileprogrammingclasses.persistence.MyDatabase

@HiltAndroidApp
class MyApplication : Application()
