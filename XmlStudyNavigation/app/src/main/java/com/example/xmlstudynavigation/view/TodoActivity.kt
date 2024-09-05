package com.example.xmlstudynavigation.view

import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.Task
import com.example.xmlstudynavigation.model.TaskCategory
import com.example.xmlstudynavigation.model.TaskCategory.*
import com.example.xmlstudynavigation.view.adapter.CategoriesAdapter
import com.example.xmlstudynavigation.view.adapter.TasksAdapter

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Learning,
        Exercise,
        Hobbies,
        Other
    )

    private val tasks = mutableListOf(
        Task("Task Learning", Learning),
        Task("Task Exercise", Exercise),
        Task("Task Hobbies", Hobbies),
        Task("Task Other", Other)
    )

    private lateinit var recyclerviewCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var recyclerViewTasks: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initUI()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        recyclerviewCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewCategory.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = tasksAdapter
    }

    private fun initComponents() {
        recyclerviewCategory = findViewById(R.id.RecyclerViewCategories)
        recyclerViewTasks = findViewById(R.id.RecyclerViewTasks)
    }
}