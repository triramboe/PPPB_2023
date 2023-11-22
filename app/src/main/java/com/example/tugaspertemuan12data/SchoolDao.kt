package com.example.tugaspertemuan12data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(school: School)

    @Update
    fun update(school: School)

    @Delete
    fun delete(school: School)

    @get:Query("SELECT * from school_table ORDER BY id ASC")
    val allSchool: LiveData<List<School>>

}