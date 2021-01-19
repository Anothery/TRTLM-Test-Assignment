package com.sudzu.trtlmtest.ui.bugdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudzu.trtlmtest.data.BugsRepo
import com.sudzu.trtlmtest.data.model.Bug
import kotlinx.coroutines.launch
import javax.inject.Inject

class BugDetailsViewModel @Inject constructor(private val bugsRepository: BugsRepo) :
    ViewModel() {
    private val _details = MutableLiveData<Bug>()
    val details: LiveData<Bug> get() = _details

    fun onBugIdCatched(bugId: Int) {
        viewModelScope.launch {
            _details.value = bugsRepository.getBug(bugId)
        }
    }
}