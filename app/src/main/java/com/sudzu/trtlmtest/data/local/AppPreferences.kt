package com.sudzu.trtlmtest.data.local

import com.sudzu.trtlmtest.utils.BugsSortType

interface AppPreferences {
    fun saveBugsSortType(sortType: BugsSortType)

    fun getBugsSortType(): BugsSortType?
}