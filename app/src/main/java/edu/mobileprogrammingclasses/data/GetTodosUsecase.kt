package edu.mobileprogrammingclasses.data

import edu.mobileprogrammingclasses.data.Todo
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.todo.TodoMapper
import edu.mobileprogrammingclasses.todo.TodosApiService
import java.net.UnknownHostException
import javax.inject.Inject

class GetTodosUsecase @Inject constructor(
  private val todosApiService: TodosApiService,
  private val todosDao: TodoDao,
  private val todosMapper: TodoMapper
) {

  suspend fun call(): List<Todo> =
    try {
      todosApiService.getTodos()
        .apply {
          map(todosMapper::mapTodoToEntity).apply { todosDao.insert(this) }
        }
    } catch (e: UnknownHostException) {
      todosDao.getTodos().map(todosMapper::mapEntityToTodo)
    }
}
