package edu.mobileprogrammingclasses.todo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import edu.mobileprogrammingclasses.R
import edu.mobileprogrammingclasses.databinding.FragmentStartBinding
import edu.mobileprogrammingclasses.todo.TodosViewState.Loading
import edu.mobileprogrammingclasses.todo.TodosViewState.Result
import edu.mobileprogrammingclasses.toggle.ToggleTodoService

@AndroidEntryPoint
class TodosFragment : Fragment() {

  private lateinit var binding: FragmentStartBinding

  private val viewModel: TodosViewModel by viewModels()

  private val todosAdapter = TodosListAdapter(emptyList())

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    binding = FragmentStartBinding.inflate(inflater, container, false)

    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.navigationButton.setOnClickListener {
//      findNavController().navigate(R.id.actionNavigateToSecondScreen)
      requireActivity().startService(Intent(requireContext(), ToggleTodoService::class.java))
    }

    binding.todoList.apply {
      adapter = todosAdapter
      layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    viewModel.responseLiveData.observe(viewLifecycleOwner) {
      when (it) {
        Loading -> {
        }

        is Result -> {
          todosAdapter.data = it.response
          todosAdapter.notifyDataSetChanged()
        }
      }
    }

    findNavController()

    viewModel.makeNetworkCall()
  }
}
