package com.example.tugaspertemuan12data

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [School::class],
    version = 1,
    exportSchema = false)

abstract class SchoolRoomDatabase : RoomDatabase(){
    abstract fun schoolDao() : SchoolDao?

    companion object {
        @Volatile
        private var INSTANCE : SchoolRoomDatabase ? = null
        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context) : SchoolRoomDatabase?{
            if (INSTANCE == null){
                synchronized(SchoolRoomDatabase::class.java){
                    INSTANCE = databaseBuilder(
                        context.applicationContext,
                        SchoolRoomDatabase::class.java, "school_database"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }
    }
}