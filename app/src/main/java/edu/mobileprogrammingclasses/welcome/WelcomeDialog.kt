package edu.mobileprogrammingclasses.welcome

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.core.edit
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import edu.mobileprogrammingclasses.USER_HAS_SEEN_WELCOME
import edu.mobileprogrammingclasses.dataStore
import edu.mobileprogrammingclasses.databinding.DialogWelcomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WelcomeDialog : DialogFragment() {

  private lateinit var binding: DialogWelcomeBinding
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = DialogWelcomeBinding.inflate(inflater, container, false)
    binding.goToTheAppButton.setOnClickListener { onGoToAppClicked() }
    return binding.root
  }

  override fun onDismiss(dialog: DialogInterface) {
    super.onDismiss(dialog)

    GlobalScope.launch {
      Log.d("Preferences", "Starting datastore write")
      requireContext().dataStore
        .edit {
          Log.d("Preferences", "Setting value")
          it[USER_HAS_SEEN_WELCOME] = true
        }
    }.invokeOnCompletion {
      Log.d("Preferences", "Possible error $it")
    }
  }

  private fun onGoToAppClicked() = dismiss()
}
