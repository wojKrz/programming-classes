package edu.mobileprogrammingclasses.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.mobileprogrammingclasses.databinding.FragmentStartBinding
import edu.mobileprogrammingclasses.todo.TodosViewState.Loading
import edu.mobileprogrammingclasses.todo.TodosViewState.Result

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

    binding.todoList.apply {
      adapter = todosAdapter
      layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    }

    viewModel.responseLiveData.observe(viewLifecycleOwner) {
      when(it) {
        Loading -> {
        }
        is Result -> {
          todosAdapter.data = it.response
          todosAdapter.notifyDataSetChanged()
        }
      }
    }

    viewModel.makeNetworkCall()
  }
}
