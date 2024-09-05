package com.example.xmlstudynavigation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val tvItemCategoryName: TextView = view.findViewById(R.id.TvItemCategoryName)
    private val viewDividerItemTasks: View = view.findViewById(R.id.view_divider_item_tasks)

    fun render(taskCategory: TaskCategory) {

    }
}