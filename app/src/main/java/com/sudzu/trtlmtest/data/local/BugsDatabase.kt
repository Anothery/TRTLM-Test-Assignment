package com.sudzu.trtlmtest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sudzu.trtlmtest.data.model.Bug

@Database(
    entities = [Bug::class],
    version = 1,
    exportSchema = false
)
abstract class BugsDatabase : RoomDatabase() {
    abstract fun bugsDao(): BugsDao
}