package edu.mobileprogrammingclasses.primary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import edu.mobileprogrammingclasses.R
import edu.mobileprogrammingclasses.primary.TodoListAdapter.TodoListViewHolder
import kotlinx.coroutines.withContext

class TodoListAdapter(var todos: List<Todo>) : Adapter<TodoListViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.item_todo, parent, false)

    return TodoListViewHolder(view)
  }

  override fun getItemCount(): Int = todos.size

  override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
    with(todos[position]) {
      holder.title.text = title
      holder.completedToggle.isActivated = completed
    }
  }

  class TodoListViewHolder(item: View) : ViewHolder(item) {
    val title: TextView
    val completedToggle: AppCompatToggleButton

    init {
      title = item.findViewById(R.id.titeText)
      completedToggle = item.findViewById(R.id.completedSwitch)
    }
  }
}
