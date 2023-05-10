package com.example.todo_app_kt.ViewModel

import com.example.todo_app_kt.Models.TaskItem

interface TaskItemClickListener
{
    fun editTaskItem(taskItem: TaskItem)
    fun completeTaskItem(taskItem: TaskItem)
}