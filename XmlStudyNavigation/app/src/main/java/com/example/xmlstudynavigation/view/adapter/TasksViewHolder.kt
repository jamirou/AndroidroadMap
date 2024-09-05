package com.example.xmlstudynavigation.view.adapter

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.Task

class TasksViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val textViewTasks:TextView = view.findViewById(R.id.TextViewTasks)
    private val checkBox:CheckBox = view.findViewById(R.id.CheckBoxTasks)

    fun render(task: Task) {
        textViewTasks.text = task.name
    }
}