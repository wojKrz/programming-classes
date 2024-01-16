package edu.mobileprogrammingclasses.todo

import edu.mobileprogrammingclasses.data.Todo
import edu.mobileprogrammingclasses.persistence.todo.TodoEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoMapper @Inject constructor() {

  fun mapEntityToTodo(entity: TodoEntity): Todo = with(entity) {
    Todo(
      id = id,
      userId = userId,
      title = title,
      completed = completed
    )
  }

  fun mapTodoToEntity(todo: Todo): TodoEntity = with(todo) {
    TodoEntity(
      id = id,
      userId = userId,
      title = title,
      completed = completed
    )
  }
}
