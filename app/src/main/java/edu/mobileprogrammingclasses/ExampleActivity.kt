package edu.mobileprogrammingclasses

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class ExampleActivity : AppCompatActivity() {

  private val viewModel: ExampleViewModel by lazy { ViewModelProvider(this)[ExampleViewModel::class.java] }

  override fun onStart() {
    super.onStart()
    viewModel.performNetworkCall()

    viewModel.resultLiveData.observe(this) {
      Log.d("Result", it)
    }
  }
}
