package edu.mobileprogrammingclasses.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import edu.mobileprogrammingclasses.MyApplication
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

  @Singleton
  @Provides
  fun provideDatabase(@ApplicationContext applicationContext: Context): MyDatabase =
    Room.databaseBuilder(applicationContext, MyDatabase::class.java, "my_database.db")
    .fallbackToDestructiveMigration()
    .build()

  @Singleton
  @Provides
  fun provideTodosDao(database: MyDatabase): TodoDao = MyApplication.database.getTodosDao()

}
