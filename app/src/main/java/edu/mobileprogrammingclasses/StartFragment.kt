package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.mobileprogrammingclasses.databinding.FragmentStartBinding

class StartFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val binding = FragmentStartBinding.inflate(inflater, container, false)

    binding.myButton.setOnClickListener {
      findNavController().navigate(R.id.actionNavigateToSecondScreen)
    }

    return binding.root
  }
}
