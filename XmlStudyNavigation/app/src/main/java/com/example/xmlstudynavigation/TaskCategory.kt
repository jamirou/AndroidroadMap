package com.example.xmlstudynavigation

sealed class TaskCategory {
    object learning : TaskCategory()
    object exercise : TaskCategory()
    object hobbies : TaskCategory()
    object other : TaskCategory()
}

