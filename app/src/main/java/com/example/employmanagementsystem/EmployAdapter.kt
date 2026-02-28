package com.example.employmanagementsystem

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employmanagementsystem.databinding.ItemlistBinding

class EmployAdapter(
    private val list: List<Data>,
    private val onedit: (Data) -> Unit,
    private val ondelete: (Data) -> Unit,
    private val onitem: (Data) -> Unit
) : RecyclerView.Adapter<EmployAdapter.viewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {

        val binding = ItemlistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return viewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: viewHolder,
        position: Int
    ) {
        val data = list[position]
        holder.binding.employimage.setImageResource(R.drawable.ic_launcher_background)
        holder.binding.tvEmployeeName.text = data.name
        holder.binding.tvEmployeeRole.text = data.position


        holder.binding.btnEdit.setOnClickListener {
            onedit(data)
        }

        holder.binding.btnDelete.setOnClickListener {
            ondelete(data)
        }
        holder.binding.root.setOnClickListener {
            onitem(data)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class viewHolder(val binding: ItemlistBinding) : RecyclerView.ViewHolder(binding.root)
}