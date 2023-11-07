package edu.mobileprogrammingclasses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import edu.mobileprogrammingclasses.PrimaryViewState.Data
import edu.mobileprogrammingclasses.PrimaryViewState.IsLoading
import edu.mobileprogrammingclasses.databinding.FragmentPrimaryBinding

class PrimaryFragment : Fragment() {

  lateinit var binding: FragmentPrimaryBinding

  private val viewModel: PrimaryViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPrimaryBinding.inflate(inflater, container, false)

    binding.myButton.setOnClickListener {
      viewModel.makeNetworkCall()
    }

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel.resultLiveData.observe(viewLifecycleOwner) {
      when(it) {
        is Data -> {
          binding.helloWorldText.text = it.response
          binding.progressCircular.visibility = View.GONE
        }
        IsLoading -> binding.progressCircular.visibility = View.VISIBLE
      }
    }
  }
}
