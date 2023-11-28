package edu.mobileprogrammingclasses.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.mobileprogrammingclasses.todo.TodosViewState.Loading
import edu.mobileprogrammingclasses.todo.TodosViewState.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodosViewModel : ViewModel() {
  private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply { this.setLevel(HttpLoggingInterceptor.Level.BODY) })
    .build()

  private val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(okHttpClient)
    .build()

  private val todosApiService: TodosApiService = retrofit.create(TodosApiService::class.java)

  private val _responseLiveData = MutableLiveData<TodosViewState>()
  val responseLiveData: LiveData<TodosViewState> = _responseLiveData
  fun makeNetworkCall() {
    _responseLiveData.value = Loading
    viewModelScope.launch {
      val response = withContext(Dispatchers.IO) {
        todosApiService.getTodos()
      }

      withContext(Dispatchers.Main)
      {
        _responseLiveData.value = Result(response)
      }
    }
  }
}
