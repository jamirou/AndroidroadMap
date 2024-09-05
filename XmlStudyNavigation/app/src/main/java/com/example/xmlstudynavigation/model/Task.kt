package com.example.xmlstudynavigation.model

data class Task(
    val name: String,
    val category: TaskCategory,
    var isSelected: Boolean = false
)
