package edu.mobileprogrammingclasses

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.mobileprogrammingclasses.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil.setContentView<ActivityStartBinding>(this, R.layout.activity_start)

    Log.d("Lifecycle", "OnCreate")
  }

  override fun onStart() {
    super.onStart()

    Log.d("Lifecycle", "OnStart")
  }

  override fun onResume() {
    super.onResume()
    Log.d("Lifecycle", "OnResume")
  }

  override fun onPause() {
    super.onPause()
    Log.d("Lifecycle", "OnPause")
  }

  override fun onStop() {
    super.onStop()
    Log.d("Lifecycle", "OnStop")
  }

  override fun onDestroy() {
    super.onDestroy()
    Log.d("Lifecycle", "OnDestroy")
  }
}
