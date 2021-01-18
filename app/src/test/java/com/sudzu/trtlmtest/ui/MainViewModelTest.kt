package com.sudzu.trtlmtest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.sudzu.trtlmtest.data.BugsRepo
import com.sudzu.trtlmtest.data.local.AppPreferences
import com.sudzu.trtlmtest.data.model.Bug
import com.sudzu.trtlmtest.ui.main.MainViewModel
import com.sudzu.trtlmtest.ui.util.MainCoroutineRule
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockRepository: BugsRepo

    private lateinit var mockAppPreferences: AppPreferences

    private lateinit var mainViewModel: MainViewModel

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(newSingleThreadContext("UI thread"))
        mockRepository = mockk()
        mockAppPreferences = mockk()
        mainViewModel = MainViewModel(mockRepository, mockAppPreferences)
    }

    @Test
    fun showDataFromRepositoryAfterInitialization() {
        runBlocking {

            val bugsObserver = mockk<Observer<List<Bug>>>()
            // TODO showDataFromRepositoryAfterInitialization

        }
    }


}