package com.example.h_w_1_4month.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.h_w_1_4month.databinding.ItemTaskBinding
import com.example.h_w_1_4month.ui.model.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val data= arrayListOf<Task>()
    fun addTask(task: Task){
        data.add(0,task)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(ItemTaskBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
return data.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
   holder.bind(data.get(position))
    }

    class  TaskViewHolder(private  val binding:ItemTaskBinding):ViewHolder(binding.root) {
        fun bind(task:  Task) {
binding.textViewTitle.text=task.title
            binding.textViewDesc.text=task.desc
        }
    }
}