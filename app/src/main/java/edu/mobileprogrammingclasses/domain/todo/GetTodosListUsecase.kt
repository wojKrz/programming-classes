package edu.mobileprogrammingclasses.domain.todo

import edu.mobileprogrammingclasses.networking.todo.TodosApiService
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.primary.Todo
import javax.inject.Inject

class GetTodosListUsecase @Inject constructor(
  private val todosApi: TodosApiService,
  private val todosDao: TodoDao,
  private val todoMapper: TodoMapper,
) {

  suspend fun execute(): List<Todo> =
    try {
      todosApi.listTodos()
        .apply {
          this.map(todoMapper::mapTodoToDatabaseEntity)
            .apply(todosDao::insertAllTodos)
        }
    } catch (e: Exception) {
      todosDao.getAllTodos().map(todoMapper::mapEntityToTodo)
    }
}
