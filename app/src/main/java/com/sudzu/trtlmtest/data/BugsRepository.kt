package com.sudzu.trtlmtest.data

import com.sudzu.trtlmtest.data.model.Bug

interface BugsRepository {
    suspend fun getBugs(): List<Bug>

    suspend fun getBug(bugId: Int): Bug?

    suspend fun hasNewData(): Boolean
}