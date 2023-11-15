package com.example.tugaspertemuan11

import com.google.gson.annotations.SerializedName

data class ApiResponse (
    @SerializedName("dataSekolah" ) var dataSekolah : ArrayList<DataSekolah> = arrayListOf()
)


data class DataSekolah (

    @SerializedName("kode_prop"      ) var kodeProp      : String? = null,
    @SerializedName("propinsi"       ) var propinsi      : String? = null,
    @SerializedName("kode_kab_kota"  ) var kodeKabKota   : String? = null,
    @SerializedName("kabupaten_kota" ) var kabupatenKota : String? = null,
    @SerializedName("kode_kec"       ) var kodeKec       : String? = null,
    @SerializedName("kecamatan"      ) var kecamatan     : String? = null,
    @SerializedName("id"             ) var id            : String? = null,
    @SerializedName("npsn"           ) var npsn          : String? = null,
    @SerializedName("sekolah"        ) var sekolah       : String? = null,
    @SerializedName("bentuk"         ) var bentuk        : String? = null,
    @SerializedName("status"         ) var status        : String? = null,
    @SerializedName("alamat_jalan"   ) var alamatJalan   : String? = null,
    @SerializedName("lintang"        ) var lintang       : String? = null,
    @SerializedName("bujur"          ) var bujur         : String? = null

)