package edu.mobileprogrammingclasses.primary

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import edu.mobileprogrammingclasses.primary.PrimaryViewState.IsLoading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PrimaryViewModel : ViewModel() {

  private val loggingInterceptor = HttpLoggingInterceptor().also {
    it.level = HttpLoggingInterceptor.Level.BODY
  }

  private val netClient = OkHttpClient.Builder()
    .addInterceptor(loggingInterceptor)
    .build()
  private val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .client(netClient)
    .build()

  private val _resultLiveData = MutableLiveData<PrimaryViewState>()
  val resultLiveData: LiveData<PrimaryViewState> = _resultLiveData

  fun makeNetworkCall() {
    Log.d("Component instances", this.toString())

    val todosApi = retrofit.create(TodosApiService::class.java)

    _resultLiveData.value = IsLoading

   viewModelScope.launch {

      val netDeffered = async(Dispatchers.IO) {
        todosApi.listTodos()
      }

      _resultLiveData.value = netDeffered.await()
        .run(PrimaryViewState::Data)
    }
  }
}

sealed class PrimaryViewState {
  data object IsLoading: PrimaryViewState()
  data class Data(val todos: List<Todo>) : PrimaryViewState()
}
