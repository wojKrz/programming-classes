package edu.mobileprogrammingclasses.persistence.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
abstract class TodoDao {

  @Query("SELECT * FROM todos")
  abstract suspend fun getTodos(): List<TodoEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  abstract suspend fun insert(entities: List<TodoEntity>)
}
