package edu.mobileprogrammingclasses.todo

sealed class TodosViewState {
  data class Result(val response: List<Todo>): TodosViewState()
  data object Loading: TodosViewState()
}
