package com.example.xmlstudynavigation.model

sealed class TaskCategory {
    data object Learning : TaskCategory()
    data object Exercise : TaskCategory()
    data object Hobbies : TaskCategory()
    data object Other : TaskCategory()
}

