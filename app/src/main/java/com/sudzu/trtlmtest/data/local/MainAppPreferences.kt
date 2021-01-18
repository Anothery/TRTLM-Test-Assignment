package com.sudzu.trtlmtest.data.local

import android.content.Context
import com.sudzu.trtlmtest.utils.BugsSortType
import javax.inject.Inject

class MainAppPreferences @Inject constructor(context: Context) : AppPreferences {

    companion object {
        const val TAG = "AppPreferences"
        private const val BUGS_SORT_TYPE = "SORT_TYPE"
    }

    private val prefs = context.getSharedPreferences(TAG, Context.MODE_PRIVATE)

    override fun saveBugsSortType(sortType: BugsSortType) {
        prefs.edit().putInt(BUGS_SORT_TYPE, sortType.ordinal).apply()
    }

    override fun getBugsSortType() =
        BugsSortType.values().getOrNull(prefs.getInt(BUGS_SORT_TYPE, -1))
}