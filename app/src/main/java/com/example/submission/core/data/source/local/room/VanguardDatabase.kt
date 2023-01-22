package com.example.submission.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.submission.core.data.source.local.entity.VanguardEntity

@Database(entities = [VanguardEntity::class], version = 1, exportSchema = false)
abstract class VanguardDatabase : RoomDatabase() {

    abstract fun vanguardDao() : VanguardDao

}