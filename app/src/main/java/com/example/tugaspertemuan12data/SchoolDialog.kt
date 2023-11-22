package com.example.tugaspertemuan12data

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.tugaspertemuan12data.databinding.ActivityAddSchoolBinding

class SchoolDialog (private val activity: MainActivity, private val school: School? = null): DialogFragment() {
    val binding by lazy {
        ActivityAddSchoolBinding.inflate(layoutInflater)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        builder.apply {
            if (school == null){
                setPositiveButton("Tambah"){
                    dialog, which ->
                    insert(School(school = binding.editTextSchoolName.text.toString(),
                        npsn = binding.editTextNPSN.text.toString(),
                        alamat = binding.editTextAlamat.text.toString(),
                        kabupaten_kota = binding.editTextKabKota.text.toString(),
                        provinsi = binding.editTextProvinsi.text.toString()))
                    dismiss()
                }
            }
            else{
                with(binding){
                    editTextSchoolName.setText(school.school)
                    editTextNPSN.setText(school.npsn)
                    editTextAlamat.setText(school.alamat)
                    editTextKabKota.setText(school.kabupaten_kota)
                    editTextProvinsi.setText(school.provinsi)
                }

                setPositiveButton("Edit"){
                        dialog, which ->
                    update(School(school = binding.editTextSchoolName.text.toString(),
                        npsn = binding.editTextNPSN.text.toString(),
                        alamat = binding.editTextAlamat.text.toString(),
                        kabupaten_kota = binding.editTextKabKota.text.toString(),
                        provinsi = binding.editTextProvinsi.text.toString()))
                    dismiss()
                }
                setNeutralButton("Hapus Catatan") {
                        dialog, which ->
                    delete(school)
                    dismiss()
                }
            }
        }
        builder.setView(binding.root).setTitle("Daftar Sekolah")
        return builder.create()
    }
    private fun insert(school: School) {
        activity.executorService.execute {
            activity.mSchoolsDao.insert(school)
        }
    }
    private fun update(school: School) {
        activity.executorService.execute {
            activity.mSchoolsDao.update(school)
        }
    }
    private fun delete(school: School) {
        activity.executorService.execute {
            activity.mSchoolsDao.delete(school)
        }
    }
}