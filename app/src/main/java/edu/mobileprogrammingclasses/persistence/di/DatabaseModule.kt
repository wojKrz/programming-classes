package edu.mobileprogrammingclasses.persistence.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.mobileprogrammingclasses.persistence.MyDatabase
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

  @Provides
  @Singleton
  fun provideDatabase(@ApplicationContext applicationContext: Context): MyDatabase =
    Room.databaseBuilder(applicationContext, MyDatabase::class.java, "my_database.db")
      .fallbackToDestructiveMigration()
      .build()

  @Provides
  @Singleton
  fun provideTodoDao(database: MyDatabase): TodoDao =
    database.todoDao()

}
