package com.example.todo_app_kt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_app_kt.Models.TaskItem
import com.example.todo_app_kt.ViewModel.TaskItemClickListener
import com.example.todo_app_kt.databinding.TaskItemCellBinding

class TaskItemAdapter(
    private val taskItems: List<TaskItem>,
    private val clickListener: TaskItemClickListener

): RecyclerView.Adapter<TaskItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder {

        val from = LayoutInflater.from(parent.context)
        val binding = TaskItemCellBinding.inflate(from,parent,false)
        return TaskItemViewHolder(parent.context,binding,clickListener)
    }

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {

        holder.bindTaskItem(taskItems[position])
    }

    override fun getItemCount(): Int {
        return taskItems.size
    }
}
