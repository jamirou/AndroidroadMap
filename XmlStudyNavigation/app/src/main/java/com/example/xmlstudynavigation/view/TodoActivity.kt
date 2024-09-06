package com.example.xmlstudynavigation.view

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
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
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

    private lateinit var fabAddTask: FloatingActionButton


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
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showAddTaskDialog() }
    }

    private fun showAddTaskDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.item_dialog_tasks)
        val editTextTasks: EditText = dialog.findViewById(R.id.EditTextTasks)
        val buttonAddTask: AppCompatButton = dialog.findViewById(R.id.ButtonAddNewTaskDialog)
        val radioGroup: RadioGroup = dialog.findViewById(R.id.RadioGroupTasks)

        buttonAddTask.setOnClickListener {
            val currentTask = editTextTasks.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = radioGroup.checkedRadioButtonId
                val selectedRadioButton: RadioButton = radioGroup.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.learning_radiobutton_text) -> Learning
                    getString(R.string.learning_radiobutton_exercise) -> Exercise
                    getString(R.string.learning_radiobutton_hobbies) -> Hobbies
                    getString(R.string.learning_radiobutton_other) -> Other
                    else -> Other
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            } else {
                Toast.makeText(this, "Please enter a task", Toast.LENGTH_SHORT).show()
            }
        }

        dialog.show()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        recyclerviewCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerviewCategory.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        recyclerViewTasks.adapter = tasksAdapter
    }

    private fun initComponents() {
        recyclerviewCategory = findViewById(R.id.RecyclerViewCategories)
        recyclerViewTasks = findViewById(R.id.RecyclerViewTasks)
        fabAddTask = findViewById(R.id.FAVTasks)
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTasks() {
        tasksAdapter.notifyDataSetChanged()
    }
}