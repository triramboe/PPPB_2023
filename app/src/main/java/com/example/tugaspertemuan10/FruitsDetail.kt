package com.example.tugaspertemuan10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tugaspertemuan10.databinding.ActivityFruitsDetailBinding

class FruitsDetail : AppCompatActivity() {

    private lateinit var binding: ActivityFruitsDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            val data = intent.getParcelableExtra<Fruits>("det_fruits")
            if (data != null) {
                titleFruitsDetail.text = data.name
                binomialFruitsDetail.text = data.binomialName
                descFruitsDetail.text = data.deskripsi
                imgFruitsDetail.setBackgroundResource(0)
                Glide.with(this@FruitsDetail).load(data.imgFruits).into(imgFruitsDetail)


            }
        }
    }
}