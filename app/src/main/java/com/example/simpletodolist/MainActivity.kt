package com.example.simpletodolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.simpletodolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "binding is null"
        }

    private val taskListViewModel: TaskListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        binding.todoListRecycleView.layoutManager = LinearLayoutManager(this)

        val tasks = taskListViewModel.getAllTasks()
        val taskListAdapter = TaskListAdapter(tasks)

        binding.todoListRecycleView.adapter = taskListAdapter
        setContentView(binding.root)

        binding.addNewTaskButton.setOnClickListener {
            if (binding.addNewTaskEditText.text.isNotEmpty()) {
                val newTaskTitle = binding.addNewTaskEditText.text.toString()
                taskListViewModel.addTask(newTaskTitle)
                taskListAdapter.notifyItemInserted(taskListAdapter.itemCount)
            }
        }
    }
}
