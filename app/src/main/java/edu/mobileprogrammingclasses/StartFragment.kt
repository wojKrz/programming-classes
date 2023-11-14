package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.mobileprogrammingclasses.databinding.FragmentStartBinding

class StartFragment : Fragment() {

  private lateinit var binding: FragmentStartBinding

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentStartBinding.inflate(inflater, container, false)

    binding.myButton.setOnClickListener { navigateToNextFragmentWithTextInputContent() }

    return binding.root
  }

  private fun navigateToNextFragmentWithTextInputContent() {
    val text = binding.testInput.text?.toString() ?: ""

    findNavController().navigate(StartFragmentDirections.actionNavigateToSecondScreen(text))
  }
}
