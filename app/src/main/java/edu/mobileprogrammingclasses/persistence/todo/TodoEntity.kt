package edu.mobileprogrammingclasses.persistence.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity(
  @PrimaryKey val id: Long,
  @ColumnInfo(name = "user_id") val userId: Long,
  val title: String,
  val completed: Boolean
)
