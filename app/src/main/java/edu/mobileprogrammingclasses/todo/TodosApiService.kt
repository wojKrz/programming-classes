package edu.mobileprogrammingclasses.todo

import edu.mobileprogrammingclasses.data.Todo
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface TodosApiService {

  @GET("todos")
  suspend fun getTodos(): List<Todo>

  @PUT("todos/toggle")
  suspend fun saveTodoState(@Body todoId: Int)

}
