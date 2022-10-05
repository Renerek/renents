package com.employee.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.employee.databinding.EmployeeItemBinding
import com.employee.domain.model.Employee

class EmployeeAdapter : RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>() {

    private var list: List<Employee> = arrayListOf()
    fun setContentList(list: List<Employee>) {
        this.list = list
        notifyDataSetChanged()
    }

    class MyViewHolder(val viewHolder: EmployeeItemBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding =
            EmployeeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewHolder.employee = this.list[position]
    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}