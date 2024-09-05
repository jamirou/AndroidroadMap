package com.example.xmlstudynavigation.model

sealed class TaskCategory {
    object learning : TaskCategory()
    object exercise : TaskCategory()
    object hobbies : TaskCategory()
    object other : TaskCategory()
}

