package com.example.tugaspertemuan10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tugaspertemuan10.databinding.FruitsItemBinding

typealias OnClickFruits = (Fruits) -> Unit

class FruitsAdapter(private val listFruits : List<Fruits>,
        private val onClickFruits: OnClickFruits):
    RecyclerView.Adapter<FruitsAdapter.ItemFruitsViewHolder>(){

    inner class ItemFruitsViewHolder(private val binding: FruitsItemBinding)
            : RecyclerView.ViewHolder(binding.root){

        fun bind(data : Fruits){
            with(binding){
                namrFruits.text = data.name
                binomialName.text = data.binomialName
                fruitsGenus.text = data.genus

                imgIconFruit.setBackgroundResource(0)
                Glide.with(itemView).load(data.imgFruits).into(imgIconFruit)

                itemView.setOnClickListener{
                    onClickFruits(data)
                }
            }
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsAdapter.ItemFruitsViewHolder {
        val binding = FruitsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FruitsAdapter.ItemFruitsViewHolder, position: Int) {
        holder.bind(listFruits[position])
    }

    override fun getItemCount(): Int {
        return listFruits.size
    }
}
