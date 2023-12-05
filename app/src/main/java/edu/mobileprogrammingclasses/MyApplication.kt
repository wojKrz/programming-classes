package edu.mobileprogrammingclasses

import android.app.Application
import android.content.Context
import androidx.room.Room
import edu.mobileprogrammingclasses.persistence.MyDatabase


class MyApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    database = Room.databaseBuilder(this, MyDatabase::class.java, "my_database.db")
      .fallbackToDestructiveMigration()
      .build()
  }

  companion object {
    lateinit var database: MyDatabase
  }
}
