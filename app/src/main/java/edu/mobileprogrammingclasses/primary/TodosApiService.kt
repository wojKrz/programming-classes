package edu.mobileprogrammingclasses.primary

import retrofit2.Call
import retrofit2.http.GET

interface TodosApiService {

  @GET("todos/")
  suspend fun listTodos(): List<Todo>
}
