package com.example.simpletodolist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.simpletodolist.databinding.ListItemViewBinding

class TaskListViewHolder(private val binding: ListItemViewBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(task : Task){
        binding.listItemTitleTextView.text = task.title
        binding.root.setOnClickListener{
            Toast.makeText(binding.root.context, "click on ${task.title}", Toast.LENGTH_SHORT)
                .show()
        }
    }
}

class TaskListAdapter(val tasks : List<Task>) : RecyclerView.Adapter<TaskListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemViewBinding.inflate(inflater, parent, false)
        return TaskListViewHolder(binding)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = tasks[position]
        holder.bind(task)
    }

}