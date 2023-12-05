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
import androidx.navigation.fragment.findNavController
import edu.mobileprogrammingclasses.HAS_USER_SEEN_WELCOME_SCREEN
import edu.mobileprogrammingclasses.dataStore
import edu.mobileprogrammingclasses.databinding.DialogWelcomeBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class WelcomeDialog : DialogFragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    return DialogWelcomeBinding.inflate(inflater, container, false)
      .also {
        it.welcomeDialogButton.setOnClickListener {
          onOkButtonClicked()
        }
      }.root
  }

  override fun onDismiss(dialog: DialogInterface) {
    super.onDismiss(dialog)
    GlobalScope.launch {
      context?.dataStore?.edit {
        Log.d("Dismissing", "Editing preferences")
        it[HAS_USER_SEEN_WELCOME_SCREEN] = true
      }
    }.invokeOnCompletion {
      Log.d("Dismissing", "Completed storing $it")
    }
  }

  private fun onOkButtonClicked() {
    dismiss()
  }
}
