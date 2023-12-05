package edu.mobileprogrammingclasses.networking.todo

import edu.mobileprogrammingclasses.primary.Todo
import retrofit2.http.GET

interface TodosApiService {

  @GET("todos/")
  suspend fun listTodos(): List<Todo>
}
