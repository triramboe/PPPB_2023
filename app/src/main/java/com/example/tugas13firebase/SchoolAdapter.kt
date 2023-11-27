package com.example.tugas13firebase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas13firebase.databinding.SchoolItemBinding

class SchoolAdapter(private val listSchool: List<School>,
    private val onItemClickListener: (School)->Unit)
    :RecyclerView.Adapter<SchoolAdapter.ItemSchoolViewHolder>(){
        inner class ItemSchoolViewHolder(private val binding: SchoolItemBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(school: School){
                with(binding){
                    namaSekolah.text = school.nama
                    npsn.text= school.npsn
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSchoolViewHolder {
        val binding = SchoolItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemSchoolViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listSchool.size
    }

    override fun onBindViewHolder(holder: ItemSchoolViewHolder, position: Int) {
        holder.bind(listSchool[position])
        holder.itemView.setOnClickListener{
            onItemClickListener.invoke(listSchool[position])
            true
        }
    }
}