package com.example.tugaspertemuan11

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SekolahAdapter (private val mList: List<DataSekolah>):RecyclerView.Adapter<SekolahAdapter.ViewHolder>() {



    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val sekolahTextView : TextView = ItemView.findViewById(R.id.sekolah)
        val npsnTextView : TextView = ItemView.findViewById(R.id.npsn)
        val alamatTextView : TextView = ItemView.findViewById(R.id.alamat)
        val provinsiTextView : TextView = ItemView.findViewById(R.id.propinsi)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.school_card,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataSekolah = mList[position]

        holder.sekolahTextView.setText(dataSekolah.sekolah)
        holder.npsnTextView.setText(dataSekolah.npsn)
        holder.alamatTextView.setText(dataSekolah.alamatJalan)
        holder.provinsiTextView.setText(dataSekolah.propinsi)
    }
}