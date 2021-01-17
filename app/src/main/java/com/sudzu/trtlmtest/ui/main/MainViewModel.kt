package com.sudzu.trtlmtest.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.data.model.Bug
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val bugsRepository: BugsRepository) : ViewModel() {
    private val _bugs = MutableLiveData<List<Bug>>()
    val bugs: LiveData<List<Bug>> get() = _bugs


    init {
        viewModelScope.launch {
            _bugs.value = bugsRepository.getBugs()
        }
    }

    fun onBugItemClicked(bugId : Int) {
        TODO("onBugItemClicked")
    }
}