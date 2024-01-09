package edu.mobileprogrammingclasses.primary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.mobileprogrammingclasses.MyApplication
import edu.mobileprogrammingclasses.domain.todo.GetTodosListUsecase
import edu.mobileprogrammingclasses.domain.todo.TodoMapper
import edu.mobileprogrammingclasses.networking.todo.TodosApiService
import edu.mobileprogrammingclasses.primary.PrimaryViewState.IsLoading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

@HiltViewModel
class PrimaryViewModel @Inject constructor(
  private val getTodosListUsecase: GetTodosListUsecase,
  @FirstString private val firstString: String,
  @SecondString private val secondString: String,
  private val cat: Cat
) : ViewModel() {

  private val _resultLiveData = MutableLiveData<PrimaryViewState>()
  val resultLiveData: LiveData<PrimaryViewState> = _resultLiveData

  fun makeNetworkCall() {
    Log.d("Component instances", this.toString())

    _resultLiveData.value = IsLoading

    viewModelScope.launch {
      val result = async(Dispatchers.IO) { getTodosListUsecase.execute() }.await()
      _resultLiveData.value = result
        .run {
          PrimaryViewState.Data(
            this, secondString, cat.doTheSound()
          )
        }
    }
  }
}

sealed class PrimaryViewState {
  data object IsLoading : PrimaryViewState()
  data class Data(val todos: List<Todo>, val firstString: String, val secondString: String) :
    PrimaryViewState()
}
