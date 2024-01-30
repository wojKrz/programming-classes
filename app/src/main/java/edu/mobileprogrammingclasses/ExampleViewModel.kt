package edu.mobileprogrammingclasses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Request.Builder
import androidx.lifecycle.viewModelScope
import okhttp3.OkHttpClient

class ExampleViewModel : ViewModel() {

  private val client = OkHttpClient()
  private val _resultLiveData = MutableLiveData<String>()
  val resultLiveData: LiveData<String> = _resultLiveData

  fun performNetworkCall() {
    viewModelScope.launch {
      val result = withContext(Dispatchers.IO) {
        val request = Builder().url("https://jsonplaceholder.typicode.com/todos").build()
        client.newCall(request)
          .execute()
          .body
          ?.string().orEmpty()
      }

      _resultLiveData.value = result
    }
  }
}
