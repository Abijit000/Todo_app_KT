package com.example.todo_app_kt

import android.app.Application
import com.example.todo_app_kt.Models.TaskItemDatabase
import com.example.todo_app_kt.ViewModel.TaskItemRepo

class TodoApplication: Application()
{
    private val database by lazy { TaskItemDatabase.getDatabase(this) }
    val repository by lazy { TaskItemRepo(database.taskItemDao()) }
}