package com.example.taskmanager

//Class to hold data

data class Task(
    val title: String,
    var isChecked: Boolean = false
)