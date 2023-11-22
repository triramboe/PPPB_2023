package com.example.tugaspertemuan12data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "school_table")

data class School(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int = 0,

    @ColumnInfo(name = "nama_sekolah")
    val school: String,

    @ColumnInfo(name = "npsn_sekolah")
    val npsn: String,

    @ColumnInfo(name = "alamat_sekolah")
    val alamat: String,

    @ColumnInfo(name = "kabupaten_kota")
    val kabupaten_kota: String,

    @ColumnInfo(name = "provinsi")
    val provinsi: String,
)
