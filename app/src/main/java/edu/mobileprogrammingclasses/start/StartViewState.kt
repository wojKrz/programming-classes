package edu.mobileprogrammingclasses.start

sealed class StartViewState {
  data class Result(val response: String): StartViewState()
  data object Loading: StartViewState()
}
