package com.example.xmlstudynavigation.view.adapter

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.Task
import com.example.xmlstudynavigation.model.TaskCategory

class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textViewTasks: TextView = view.findViewById(R.id.TextViewTasks)
    private val checkBox: CheckBox = view.findViewById(R.id.CheckBoxTasks)

    fun render(task: Task) {

        if (task.isSelected) {
            textViewTasks.paintFlags = textViewTasks.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            textViewTasks.paintFlags =
                textViewTasks.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        checkBox.isChecked = task.isSelected
        textViewTasks.text = task.name

        val color = when (task.category) {
            TaskCategory.Exercise -> R.color.exercise_divider_color
            TaskCategory.Hobbies -> R.color.hobbies_divider_color
            TaskCategory.Learning -> R.color.learning_divider_color
            TaskCategory.Other -> R.color.other_divider_color
        }
        checkBox.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(checkBox.context, color)
        )
    }
}