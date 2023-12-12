package edu.mobileprogrammingclasses.persistence.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
  tableName = "todos"
)
data class TodoEntity(
  @PrimaryKey
  val id: Int,
  @ColumnInfo(name = "user_id")
  val userId: Int,
  val title: String,
  val completed: Boolean
)
