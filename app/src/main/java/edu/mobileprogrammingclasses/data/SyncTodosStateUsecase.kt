package edu.mobileprogrammingclasses.data

import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.todo.TodosApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

class SyncTodosStateUsecase @Inject constructor(
  private val todosDao: TodoDao,
  private val todosApiService: TodosApiService
) {

  suspend fun run() {
    todosDao.getUnsyncedTodos().apply {
//      todosApiService.saveTodoState(0)
    }

    delay(2000)
  }
}
