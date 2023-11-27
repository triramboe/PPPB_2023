package com.example.tugas13firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas13firebase.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val firestore = FirebaseFirestore.getInstance()
    private val schoolListLiveData: MutableLiveData<List<School>>
    by lazy {
        MutableLiveData<List<School>>()
    }

    private val schoolCollectionReference = firestore.collection("schools")
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
        observeSchool()
        getAllSchool()

    }

    private fun getAllSchool() {
        schoolCollectionReference.addSnapshotListener{snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            val schools = arrayListOf<School>()
            snapshot?.forEach{ documentReference ->
                schools.add(
                    School(
                        documentReference.id,
                        documentReference.get("nama").toString(),
                        documentReference.get("npsn").toString(),
                        documentReference.get("alamat").toString(),
                        documentReference.get("kabupaten_provinsi").toString(),
                        documentReference.get("provinsi").toString(),
                    )
                )
            }
            if (schools != null){
                schoolListLiveData.postValue(schools)
            }
        }
    }

    private fun observeSchool() {
        schoolListLiveData.observe(this){
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