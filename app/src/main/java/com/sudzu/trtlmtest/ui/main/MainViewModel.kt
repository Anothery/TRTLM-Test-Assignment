package com.sudzu.trtlmtest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudzu.trtlmtest.data.BugsRepo
import com.sudzu.trtlmtest.data.local.AppPreferences
import com.sudzu.trtlmtest.data.model.Bug
import com.sudzu.trtlmtest.utils.BugsSortType
import com.sudzu.trtlmtest.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val bugsRepository: BugsRepo,
    private val mainAppPreferences: AppPreferences
) : ViewModel() {
    private val _bugs = MutableLiveData<List<Bug>>()
    val bugs: LiveData<List<Bug>> get() = _bugs

    private val _openBugDetails = SingleLiveEvent<Int>()
    val openBugDetails: LiveData<Int> get() = _openBugDetails

    private val _showSortDialog = SingleLiveEvent<Int>()
    val showSortDialog: LiveData<Int> get() = _showSortDialog

    private val _startCheckDataService = SingleLiveEvent<Boolean>()
    val startCheckDataService: LiveData<Boolean> get() = _startCheckDataService

    private val _stopCheckDataService = SingleLiveEvent<Boolean>()
    val stopCheckDataService: LiveData<Boolean> get() = _stopCheckDataService

    init {
        _startCheckDataService.value = true

        viewModelScope.launch {
            _bugs.value = sortList(
                bugsRepository.getBugs(),
                mainAppPreferences.getBugsSortType() ?: BugsSortType.BY_ID
            )
        }
    }


    fun onBugItemClicked(bugId: Int) {
        _openBugDetails.value = bugId
    }

    fun onSortTypeChanged(ordinal: Int) {
        BugsSortType.values().getOrNull(ordinal)?.let {
            _bugs.value = sortList(_bugs.value ?: emptyList(), it)
            mainAppPreferences.saveBugsSortType(it)
        }
    }

    private fun sortList(list: List<Bug>, sortType: BugsSortType): List<Bug> {
        return when (sortType) {
            BugsSortType.BY_ID -> list.sortedBy { it.id }
            BugsSortType.BY_STATUS -> list.sortedBy { it.status }
            BugsSortType.BY_TYPE -> list.sortedBy { it.type }
        }
    }

    fun onSortButtonClicked() {
        val sortType = mainAppPreferences.getBugsSortType()
        _showSortDialog.value = sortType?.ordinal ?: BugsSortType.BY_ID.ordinal
    }

    fun onDestroy() {
        _stopCheckDataService.value = true
    }
}