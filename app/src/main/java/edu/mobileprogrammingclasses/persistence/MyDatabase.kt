package edu.mobileprogrammingclasses.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.persistence.todo.TodoEntity

@Database(
  version = 1,
  entities = [TodoEntity::class]
)
abstract class MyDatabase : RoomDatabase() {

  abstract fun todoDao(): TodoDao
}
