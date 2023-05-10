package com.example.todo_app_kt.Adapter

import android.content.Context
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app_kt.Models.TaskItem
import com.example.todo_app_kt.ViewModel.TaskItemClickListener
import com.example.todo_app_kt.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder(

    private val context: Context,
    private val binding: TaskItemCellBinding,
    private val clickListener: TaskItemClickListener
): RecyclerView.ViewHolder(binding.root)
{

    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    fun bindTaskItem(taskItem: TaskItem)
    {
        binding.taskName.text = taskItem.name
        binding.taskDesc.text = taskItem.desc

        if (taskItem.isCompleted()){
            binding.taskName.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.taskDesc.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completeButton.setImageResource(taskItem.imageResource())
        binding.completeButton.setColorFilter(taskItem.imageColor(context))

        binding.completeButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }

        binding.taskCellContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }

        if (taskItem.dueTime() !=null){
            binding.taskDueTime.text = timeFormat.format(taskItem.dueTime())

        }else{
            binding.taskDueTime.text="00:00"
        }
    }
}