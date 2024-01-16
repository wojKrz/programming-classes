package edu.mobileprogrammingclasses

import android.app.Application
import androidx.room.Room
import dagger.hilt.android.HiltAndroidApp
import edu.mobileprogrammingclasses.persistence.MyDatabase

@HiltAndroidApp
class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    database = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "my_database.db")
      .fallbackToDestructiveMigration()
      .build()
  }

  companion object {
    lateinit var database: MyDatabase
  }
}
