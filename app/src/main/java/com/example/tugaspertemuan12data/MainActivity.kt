package com.example.tugaspertemuan12data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan12data.databinding.ActivityMainBinding
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var mSchoolsDao: SchoolDao
    lateinit var executorService: ExecutorService



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            addBtn.setOnClickListener{
                showAddSchool()
            }
            rvSchool.addOnScrollListener(object: RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy > 0 || dy < 0) {
                        addBtn.visibility = View.GONE
                    }
                }
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                        addBtn.visibility = View.VISIBLE
                    }
                }
            })
        }

        executorService = Executors.newSingleThreadExecutor()
        val db = SchoolRoomDatabase.getDatabase(this)
        mSchoolsDao = db!!.schoolDao()!!
    }
    override fun onResume() {
        super.onResume()
        getAllNotes()
    }

    private fun getAllNotes() {
        mSchoolsDao.allSchool.observe(this){
            schools ->
            val listAdapter = SchoolAdapter(schools){
                selectedSchool ->
                showAddSchool(selectedSchool)
            }

            binding.rvSchool.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }

    private fun showAddSchool(school: School? = null) {
        val schoolDial = SchoolDialog(this, school)
        schoolDial.show(supportFragmentManager, "School")
    }
}