package edu.mobileprogrammingclasses

import android.content.Context
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
import edu.mobileprogrammingclasses.databinding.ActivityMainBinding
import edu.mobileprogrammingclasses.persistence.MyDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val HAS_USER_SEEN_WELCOME_SCREEN = booleanPreferencesKey("hasUserSeenWelcomeScreen")
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    Log.d("Lifecycle", "On Create")
  }

  override fun onStart() {
    super.onStart()

    lifecycleScope.launch {
      val hasUserSeenWelcomeScreen = baseContext.dataStore
        .data
        .map { it[HAS_USER_SEEN_WELCOME_SCREEN] }
        .first() ?: false

      if (hasUserSeenWelcomeScreen.not()) {
        with(findNavController(R.id.navFragment)) {
          if (currentDestination?.id != R.id.welcomeDialog) {
            navigate(R.id.actionNavigateToWeclomeDialog)
          }
        }
      }
    }
  }
}
