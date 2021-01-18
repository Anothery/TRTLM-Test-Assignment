package com.sudzu.trtlmtest.data

import com.sudzu.trtlmtest.data.local.BugsDao
import com.sudzu.trtlmtest.data.model.Bug
import com.sudzu.trtlmtest.data.network.BugsApi
import javax.inject.Inject

class BugsRepository @Inject constructor(
    private val bugsApi: BugsApi,
    private val bugsDb: BugsDao
) : BugsRepo {
    override suspend fun getBugs(): List<Bug> {
        val bugs = bugsApi.getBugs().bugDetails.map(Bug::fromResponse)
        bugsDb.insertBugs(bugs)
        return bugs
    }

    override suspend fun getBug(bugId: Int) = bugsDb.getBugById(bugId)

    override suspend fun hasNewData(): Boolean {
        val bugs = bugsApi.getBugs().bugDetails.map(Bug::fromResponse)

        bugs.getOrNull(bugs.lastIndex)?.let { serverItem ->
            bugsDb.getLatestBug()?.id?.let { dbItemId ->
                return serverItem.id != dbItemId
            } ?: return false
        } ?: return false
    }
}