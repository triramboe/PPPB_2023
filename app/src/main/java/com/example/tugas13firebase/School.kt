package com.example.tugas13firebase

import com.google.firebase.firestore.Exclude

data class School(
    @set:Exclude @get:Exclude @Exclude var id : String = "",
    var nama : String ="",
    var npsn : String ="",
    var alamat : String ="",
    var kabupaten_kota : String ="",
    var provinsi : String = "",

)
