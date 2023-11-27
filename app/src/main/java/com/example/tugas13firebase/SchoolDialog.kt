package com.example.tugas13firebase

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import com.example.tugas13firebase.databinding.ActivityAddSchoolBinding
import com.google.firebase.firestore.FirebaseFirestore

class SchoolDialog(private val activity: MainActivity, private val school: School? = null) : DialogFragment() {
    private val binding by lazy {
        ActivityAddSchoolBinding.inflate(layoutInflater)
    }

    private val firestore = FirebaseFirestore.getInstance()
    private val schoolCollectionReference = firestore.collection("schools")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.apply {
            if (school == null) {
                setPositiveButton("Tambah") { dialog, which ->
                    insert(
                        School(
                            nama = binding.editTextSchoolName.text.toString(),
                            npsn = binding.editTextNPSN.text.toString(),
                            alamat = binding.editTextAlamat.text.toString(),
                            kabupaten_kota = binding.editTextKabKota.text.toString(),
                            provinsi = binding.editTextProvinsi.text.toString()
                        )
                    )
                    dismiss()
                }
            } else {
                with(binding) {
                    editTextSchoolName.setText(school.nama)
                    editTextNPSN.setText(school.npsn)
                    editTextAlamat.setText(school.alamat)
                    editTextKabKota.setText(school.kabupaten_kota)
                    editTextProvinsi.setText(school.provinsi)
                }

                setPositiveButton("Edit") { dialog, which ->
                    update(
                        School(
                            id = school.id,
                            nama = binding.editTextSchoolName.text.toString(),
                            npsn = binding.editTextNPSN.text.toString(),
                            alamat = binding.editTextAlamat.text.toString(),
                            kabupaten_kota = binding.editTextKabKota.text.toString(),
                            provinsi = binding.editTextProvinsi.text.toString()
                        )
                    )
                    dismiss()
                }
                setNeutralButton("Hapus Catatan") { dialog, which ->
                    delete(school.id)
                    dismiss()
                }
            }
        }
        builder.setView(binding.root).setTitle("Daftar Sekolah")
        return builder.create()
    }

    private fun insert(school: School) {
        schoolCollectionReference.add(school).addOnFailureListener {
            Log.d("MainActivity", "Error adding school : ", it)
        }
    }

    private fun update(school: School) {
        schoolCollectionReference.document(school.id).set(school)
            .addOnFailureListener {
                Log.d("MainActivity", "Error updating school : ", it)
            }
    }

    private fun delete(id: String?) {
        if (id != null) {
            schoolCollectionReference.document(id).delete()
                .addOnFailureListener {
                    Log.d("MainActivity", "Error deleting school : ", it)
                }
        }
    }
}
