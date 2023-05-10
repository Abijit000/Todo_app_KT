package com.example.todo_app_kt.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo_app_kt.Adapter.TaskItemAdapter
import com.example.todo_app_kt.Fragments.NewTaskSheet
import com.example.todo_app_kt.Models.TaskItem
import com.example.todo_app_kt.TodoApplication
import com.example.todo_app_kt.ViewModel.TaskItemClickListener
import com.example.todo_app_kt.ViewModel.TaskItemModelFactory
import com.example.todo_app_kt.ViewModel.TaskViewModel
import com.example.todo_app_kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , TaskItemClickListener
{
    private lateinit var binding: ActivityMainBinding
    private  val taskViewModel: TaskViewModel by viewModels {
        TaskItemModelFactory((application as TodoApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            NewTaskSheet(null).show(supportFragmentManager,"tagNewTaskSheet")
        }
        setRecyclerView()

    }

    private fun setRecyclerView()
    {
        taskViewModel.taskItems.observe(this){
            binding.todoListRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it,this@MainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: TaskItem)
    {
        NewTaskSheet(taskItem).show(supportFragmentManager,"newTaskTag")

    }

    override fun completeTaskItem(taskItem: TaskItem)
    {
        taskViewModel.setCompleted(taskItem)
    }
}