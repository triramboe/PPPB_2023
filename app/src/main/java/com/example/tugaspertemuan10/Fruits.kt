package com.example.tugaspertemuan10

import android.os.Parcel
import android.os.Parcelable

data class Fruits(
    val name: String? = "",
    val binomialName: String? = "",
    val genus: String? = "",
    val imgFruits: String? = null,
    val deskripsi: String? = ""
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, p1: Int) {
        parcel.writeString(name)
        parcel.writeString(binomialName)
        parcel.writeString(genus)
        parcel.writeString(imgFruits)
        parcel.writeString(deskripsi)
    }

    companion object CREATOR : Parcelable.Creator<Fruits> {
        override fun createFromParcel(parcel: Parcel): Fruits {
            return Fruits(parcel)
        }

        override fun newArray(size: Int): Array<Fruits?> {
            return arrayOfNulls(size)
        }
    }
}
