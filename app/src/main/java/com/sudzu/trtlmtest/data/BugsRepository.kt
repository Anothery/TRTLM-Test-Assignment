package com.sudzu.trtlmtest.data

import com.sudzu.trtlmtest.data.local.BugsDatabase
import com.sudzu.trtlmtest.data.model.Bug
import com.sudzu.trtlmtest.data.network.BugsApi
import javax.inject.Inject

class BugsRepository @Inject constructor(
    private val bugsApi: BugsApi,
    private val db: BugsDatabase
) {
    suspend fun getBugs(): List<Bug> {
        val bugs = bugsApi.getBugs().bugDetails.map(Bug::fromResponse)
        db.bugsDao().insertBugs(bugs)
        return bugs
    }

    suspend fun getBug(bugId: Int) = db.bugsDao().getBugById(bugId)
}