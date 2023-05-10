package com.example.todo_app_kt.ViewModel

import androidx.annotation.WorkerThread
import androidx.room.Dao
import com.example.todo_app_kt.Models.TaskItem
import kotlinx.coroutines.flow.Flow

class TaskItemRepo (private val taskItemDao: TaskItemDao)
{
    val allTaskItems: Flow<List<TaskItem>> = taskItemDao.allTaskItems()

    @WorkerThread
    suspend fun insertTaskItem(taskItem: TaskItem)
    {
        taskItemDao.insertTaskItem(taskItem)

    }

    @WorkerThread
    suspend fun updateTaskItem(taskItem: TaskItem)
    {
        taskItemDao.updateTaskItem(taskItem)

    }
}