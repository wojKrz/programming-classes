package edu.mobileprogrammingclasses.toggle

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import dagger.hilt.android.AndroidEntryPoint
import edu.mobileprogrammingclasses.data.SyncTodosStateUsecase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ToggleTodoService : Service() {

  @Inject
  lateinit var syncTodosStateUsecase: SyncTodosStateUsecase

  val parentJob = Job()
  val scope: CoroutineScope = CoroutineScope(parentJob)

  override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

    Log.d(
      "Service Test",
      "Hi this is a $this Service, I have a startId $startId, ${parentJob.children.joinToString { this.toString() }}"
    )
    scope.launch(Dispatchers.IO) {
      syncTodosStateUsecase.run()
    }.invokeOnCompletion {
      stopSelf()
    }

    return super.onStartCommand(intent, flags, startId)
  }

  override fun onBind(p0: Intent?): IBinder? = null

  override fun onDestroy() {
    scope.cancel()
    super.onDestroy()
  }
}
