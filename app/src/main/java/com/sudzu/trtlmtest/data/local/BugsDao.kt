package com.sudzu.trtlmtest.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sudzu.trtlmtest.data.model.Bug

@Dao
interface BugsDao {
    @Query("SELECT * FROM bugs")
    suspend fun getBugs(): List<Bug>

    @Query("SELECT * FROM bugs WHERE id = :id")
    suspend fun getBugById(id: Int): Bug?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBug(bug: Bug)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBugs(bugs: List<Bug>)
}