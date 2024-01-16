package edu.mobileprogrammingclasses.data

import edu.mobileprogrammingclasses.persistence.todo.SyncState.SYNCED
import edu.mobileprogrammingclasses.persistence.todo.SyncState.UNSYNCED
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.todo.TodosApiService
import kotlinx.coroutines.delay
import java.net.UnknownHostException
import javax.inject.Inject

class ToggleTodoStateUsecase @Inject constructor(
  private val todosApiService: TodosApiService,
  private val todoDao: TodoDao
) {

  suspend fun run(todoId: Int) {

    try {
      todosApiService.saveTodoState(todoId)
      todoDao.saveTodoState(todoId, SYNCED)
    } catch (e: UnknownHostException) {
      todoDao.saveTodoState(todoId, UNSYNCED)
    }
    delay(1000)
  }
}
