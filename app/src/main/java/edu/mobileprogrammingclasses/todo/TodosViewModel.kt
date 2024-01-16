package edu.mobileprogrammingclasses.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.mobileprogrammingclasses.MyApplication
import edu.mobileprogrammingclasses.data.GetTodosUsecase
import edu.mobileprogrammingclasses.persistence.todo.TodoDao
import edu.mobileprogrammingclasses.todo.TodosViewState.Loading
import edu.mobileprogrammingclasses.todo.TodosViewState.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
class TodosViewModel @Inject constructor(
  private val getTodosUsecase: GetTodosUsecase
): ViewModel() {

  private val _responseLiveData = MutableLiveData<TodosViewState>()
  val responseLiveData: LiveData<TodosViewState> = _responseLiveData

  fun makeNetworkCall() {
    _responseLiveData.value = Loading
    viewModelScope.launch {
      val response = withContext(Dispatchers.IO) {
        getTodosUsecase.call()
      }

      withContext(Dispatchers.Main)
      {
        _responseLiveData.value = Result(response)
      }
    }
  }
}
