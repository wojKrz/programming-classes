package edu.mobileprogrammingclasses.start

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.mobileprogrammingclasses.start.StartViewState.Loading
import edu.mobileprogrammingclasses.start.StartViewState.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class StartViewModel : ViewModel() {
  private val okHttpClient = OkHttpClient()

  private val _responseLiveData = MutableLiveData<StartViewState>()
  val responseLiveData: LiveData<StartViewState> = _responseLiveData
  fun makeNetworkCall() {
    val request = Request.Builder()
      .url("https://jsonplaceholder.typicode.com/users")
      .build()

    _responseLiveData.value = Loading
    viewModelScope.launch {
      val response = withContext(Dispatchers.IO) {
        delay(3000)
        return@withContext okHttpClient.newCall(request).execute()
      }.body?.string() ?: ""

      withContext(Dispatchers.Main)
      {
        Log.d("Response", response)
        _responseLiveData.value = Result(response)
      }
    }
  }
}
