package com.example.todo_app_kt.ViewModel

import androidx.lifecycle.*
import com.example.todo_app_kt.Models.TaskItem
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime

class TaskViewModel(private val repository:TaskItemRepo): ViewModel()
{
    var taskItems: LiveData<List<TaskItem>> = repository.allTaskItems.asLiveData()

    fun addTaskItem(newTask: TaskItem) = viewModelScope.launch { repository.insertTaskItem(newTask) }
    fun updateTaskItem(taskItem: TaskItem) = viewModelScope.launch { repository.insertTaskItem(taskItem) }
    fun setCompleted(taskItem: TaskItem) = viewModelScope.launch {

        if (!taskItem.isCompleted())
        {
            taskItem.completedDateString = TaskItem.dateFormatter.format(LocalDate.now())
        }
        repository.insertTaskItem(taskItem)
    }

    /* fun updateTaskItem(id: UUID,name: String,desc:String, dueTime: LocalTime?)
     {
         val list= taskItems.value
         val task =list!!.find { it.id == id }!!
         task.name=name
         task.desc=desc
         task.dueTime=dueTime

         taskItems.postValue(list)
     }

     fun setCompleted(taskItem: TaskItem)
     {
         val list= taskItems.value
         val task =list!!.find { it.id == taskItem.id }!!
         if (task.completedDate == null)
             task.completedDate= LocalTime.now()
         taskItems.postValue(list)
     }*/

/*
    var name= MutableLiveData<String>()
    var desc= MutableLiveData<String>()*/
}

class TaskItemModelFactory(private val repository: TaskItemRepo): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T
        throw IllegalArgumentException("Unknown class")
    }
}