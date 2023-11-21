package edu.mobileprogrammingclasses.primary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.mobileprogrammingclasses.primary.PrimaryViewState.Data
import edu.mobileprogrammingclasses.primary.PrimaryViewState.IsLoading
import edu.mobileprogrammingclasses.databinding.FragmentPrimaryBinding

class PrimaryFragment : Fragment() {

  private val todosAdapter = TodoListAdapter(emptyList())
  lateinit var binding: FragmentPrimaryBinding

  private val viewModel: PrimaryViewModel by viewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentPrimaryBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val todosListLayoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    binding.todosList.apply {
      adapter = todosAdapter
      layoutManager = todosListLayoutManager
    }

    viewModel.resultLiveData.observe(viewLifecycleOwner) {
      when (it) {
        is Data -> {
          todosAdapter.todos = it.todos
          todosAdapter.notifyDataSetChanged()
        }
        IsLoading -> {}
      }
    }

    viewModel.makeNetworkCall()
  }
}