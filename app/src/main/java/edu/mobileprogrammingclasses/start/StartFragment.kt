package edu.mobileprogrammingclasses.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import edu.mobileprogrammingclasses.databinding.FragmentStartBinding
import edu.mobileprogrammingclasses.start.StartViewState.Loading
import edu.mobileprogrammingclasses.start.StartViewState.Result

class StartFragment : Fragment() {

  private lateinit var binding: FragmentStartBinding

  private val viewModel: StartViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentStartBinding.inflate(inflater, container, false)

    binding.myButton.setOnClickListener { viewModel.makeNetworkCall() }

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.responseLiveData.observe(viewLifecycleOwner) {
      when(it) {
        Loading -> {
          binding.progressIndicator.visibility = View.VISIBLE
          binding.responseText.visibility = View.GONE
          binding.responseText.text = ""
        }
        is Result -> {
          binding.progressIndicator.visibility = View.GONE
          binding.responseText.visibility = View.VISIBLE
          binding.responseText.text = it.response
        }
      }
    }
  }
}
