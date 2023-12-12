package edu.mobileprogrammingclasses.todo

import edu.mobileprogrammingclasses.data.Todo

sealed class TodosViewState {
  data class Result(val response: List<Todo>): TodosViewState()
  data object Loading: TodosViewState()
}
