package edu.mobileprogrammingclasses.domain.todo

import edu.mobileprogrammingclasses.persistence.todo.TodoEntity
import edu.mobileprogrammingclasses.primary.Todo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoMapper @Inject constructor() {

  fun mapTodoToDatabaseEntity(todo: Todo): TodoEntity = with(todo) {
    TodoEntity(
      id = id,
      userId = userId,
      title = title,
      completed = completed
    )
  }

  fun mapEntityToTodo(entity: TodoEntity): Todo = with(entity) {
    Todo(
      id = id,
      userId = userId,
      title = title,
      completed = completed
    )
  }
}
