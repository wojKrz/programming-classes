package edu.mobileprogrammingclasses.persistence.todo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {

  @Query("SELECT * FROM TodoEntity")
  fun getAllTodos(): List<TodoEntity>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertAllTodos(todos: List<TodoEntity>)
}
