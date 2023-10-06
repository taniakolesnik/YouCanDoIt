package com.example.simpletodolist

import androidx.lifecycle.ViewModel

class TaskListViewModel : ViewModel() {

    private val tasks = mutableListOf<Task>()

    init{
        for (i in 0..10){
            tasks += Task("task $i")
        }
    }

    fun addTask(title: String) {
        val task = Task(title)
        tasks.add(task)
    }

    fun getAllTasks() = tasks

}