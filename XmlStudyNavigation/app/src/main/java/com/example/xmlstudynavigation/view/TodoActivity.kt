package com.example.xmlstudynavigation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlstudynavigation.R
import com.example.xmlstudynavigation.model.TaskCategory
import com.example.xmlstudynavigation.view.adapter.CategoriesAdapter

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Learning,
        TaskCategory.Exercise,
        TaskCategory.Hobbies,
        TaskCategory.Other
    )

    private lateinit var recyclerviewCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

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
        recyclerviewCategory.adapter =categoriesAdapter
    }

    private fun initComponents() {
        recyclerviewCategory = findViewById(R.id.RecyclerViewCategories)
    }
}