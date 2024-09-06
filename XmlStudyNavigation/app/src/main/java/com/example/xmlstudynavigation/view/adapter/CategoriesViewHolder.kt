package com.example.xmlstudynavigation.view.adapter

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.TaskCategory

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvItemCategoryName: TextView = view.findViewById(R.id.TvItemCategoryName)
    private val viewDividerItemTasks: View = view.findViewById(R.id.view_divider_item_tasks)
    private val cardViewContainer: CardView = view.findViewById(R.id.cardViewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val colorSelected = if (taskCategory.isSelected) {
            R.color.pressed_color
        } else {
            R.color.normal_color
        }

        cardViewContainer.setCardBackgroundColor(
            ContextCompat.getColor(
                cardViewContainer.context,
                colorSelected
            )
        )

        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Exercise -> {
                tvItemCategoryName.text = "Exercise"
                viewDividerItemTasks.setBackgroundResource(R.color.exercise_divider_color)
            }

            TaskCategory.Hobbies -> {
                tvItemCategoryName.text = "Hobbies"
                viewDividerItemTasks.setBackgroundResource(R.color.hobbies_divider_color)
            }

            TaskCategory.Learning -> {
                tvItemCategoryName.text = "Learning"
                viewDividerItemTasks.setBackgroundResource(R.color.learning_divider_color)
            }

            TaskCategory.Other -> {
                tvItemCategoryName.text = "Other"
                viewDividerItemTasks.setBackgroundResource(R.color.other_divider_color)
            }
        }
    }
}