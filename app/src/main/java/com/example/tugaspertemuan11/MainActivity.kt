package com.example.tugaspertemuan11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan11.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var data = ArrayList<DataSekolah>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.recycleViews.layoutManager = LinearLayoutManager(this)

        getAllProducts()
    }

    private fun getAllProducts() {

        val retrofit = ServiceBuilder.buildService(ServiceInterface::class.java)

        retrofit.getAllProducts().enqueue(object : Callback<ApiResponse>{
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                try {

                    val responseBody = response.body()!!
                    data = responseBody.dataSekolah

                    val adapter = SekolahAdapter(data)
                    binding.recycleViews.adapter = adapter

                }
                catch (ex: java.lang.Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e("Failed", "Api Failed"+t.message)
            }

        })
    }
}