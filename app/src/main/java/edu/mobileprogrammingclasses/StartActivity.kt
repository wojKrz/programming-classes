package edu.mobileprogrammingclasses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.room.Room
import edu.mobileprogrammingclasses.databinding.ActivityStartBinding
import edu.mobileprogrammingclasses.persistence.MyDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
val USER_HAS_SEEN_WELCOME = booleanPreferencesKey("userHasSeenWelcome")

class StartActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    DataBindingUtil.setContentView<ActivityStartBinding>(this, R.layout.activity_start)

    Log.d("Lifecycle", "OnCreate")
  }

  override fun onResume() {
    super.onResume()

    lifecycleScope.launch {
      val userHasSeenWelcome = dataStore.data
        .map { it[USER_HAS_SEEN_WELCOME] ?: false }
        .first()

      Log.d("Preferences", "User seen welcome $userHasSeenWelcome")

      if (userHasSeenWelcome.not()) {
        navigateIfNotVisible(R.id.welcomeDialog, R.id.actionNavigateToWelcomeDialog)
      }
    }
  }

  private fun navigateIfNotVisible(idToCheck: Int, actionId: Int) {
    with(findNavController(R.id.fragmentContainer)) {
      if (currentDestination?.id != idToCheck) {
        navigate(actionId)
      }
    }
  }
}
