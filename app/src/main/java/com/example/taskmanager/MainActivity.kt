package com.example.taskmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        taskAdapter = TaskAdapter(mutableListOf())

        rvTaskItems.adapter = taskAdapter
        rvTaskItems.layoutManager = LinearLayoutManager(this)

        // Define what should happen upon clicking the button

        btnAddTask.setOnClickListener {
            val taskTitle = etTaskTitle.text.toString()
            if (taskTitle.isNotEmpty()) {
                val task = Task(taskTitle)
                taskAdapter.addTask(task)
                etTaskTitle.text.clear()
            }
        }
        btnDeleteDoneTask.setOnClickListener {
            taskAdapter.deleteTask()
        }
    }
}