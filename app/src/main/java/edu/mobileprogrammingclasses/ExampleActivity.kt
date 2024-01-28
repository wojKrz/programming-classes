package edu.mobileprogrammingclasses

import android.app.Activity
import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET

/**
 * This is a faulty network code that will crash.
 * How can you make it complete successfully?
 * How can you make it survive configuration changes (ie. phone rotation)?
 */

class ExampleActivity : Activity() {

  override fun onResume() {
    super.onResume()
    val result = Retrofit.Builder()
      .baseUrl("https://google.com")
      .build()
      .create(ExampleApi::class.java)
      .example()
      .execute()

    Log.d("Response", result.body().toString())
  }
}

interface ExampleApi {

  @GET("/")
  fun example(): Call<Unit>
}
