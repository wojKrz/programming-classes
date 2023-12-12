package edu.mobileprogrammingclasses.todo

import edu.mobileprogrammingclasses.data.Todo
import retrofit2.http.GET

interface TodosApiService {

  @GET("todos")
  suspend fun getTodos(): List<Todo>
}
