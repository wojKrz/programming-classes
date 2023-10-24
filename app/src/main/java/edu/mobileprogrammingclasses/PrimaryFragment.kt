package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import edu.mobileprogrammingclasses.databinding.FragmentPrimaryBinding

class PrimaryFragment : Fragment() {

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val binding = FragmentPrimaryBinding.inflate(inflater, container, false)

    binding.myButton.setOnClickListener {
      val argument = binding.textInput.text.toString()

      findNavController().navigate(
        PrimaryFragmentDirections.actionNavigateToSecondFragment(argument)
      )
    }

    return binding.root
  }

}
