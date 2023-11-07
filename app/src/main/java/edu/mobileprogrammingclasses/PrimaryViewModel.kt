package edu.mobileprogrammingclasses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.mobileprogrammingclasses.PrimaryViewState.IsLoading
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request

class PrimaryViewModel : ViewModel() {

  private val netClient = OkHttpClient()

  private val _resultLiveData = MutableLiveData<PrimaryViewState>()
  val resultLiveData: LiveData<PrimaryViewState> = _resultLiveData

  fun makeNetworkCall() {
    Log.d("Component instances", this.toString())
    val request = Request.Builder()
      .url("https://jsonplaceholder.typicode.com/todos/")
      .build()

    _resultLiveData.value = IsLoading

   viewModelScope.launch {

      val netDeffered = async(Dispatchers.IO) {
        delay(3000)
        netClient.newCall(request).execute()
      }

      _resultLiveData.value = netDeffered.await()
        .body
        ?.string()
        ?.run(PrimaryViewState::Data)
    }
  }
}

sealed class PrimaryViewState {
  data object IsLoading: PrimaryViewState()
  data class Data(val response: String) : PrimaryViewState()
}
