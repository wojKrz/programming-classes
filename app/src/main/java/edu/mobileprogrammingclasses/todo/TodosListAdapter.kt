package edu.mobileprogrammingclasses.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.recyclerview.widget.RecyclerView
import edu.mobileprogrammingclasses.R
import edu.mobileprogrammingclasses.data.Todo

class TodosListAdapter(var data: List<Todo>) :
  RecyclerView.Adapter<TodosListAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.item_todo, parent, false)
    return ViewHolder(view)
  }

  override fun getItemCount(): Int = data.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder) {
    val todo = data[position]

    nameTextView.text = todo.title
    completedToggle.isChecked = todo.completed
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView = view.findViewById(R.id.todoName)
    val completedToggle: AppCompatToggleButton = view.findViewById(R.id.isCompletedToggle)
  }
}
