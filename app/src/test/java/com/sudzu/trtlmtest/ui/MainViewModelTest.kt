package com.sudzu.trtlmtest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.data.local.AppPreferences
import com.sudzu.trtlmtest.ui.main.MainViewModel
import com.sudzu.trtlmtest.ui.util.InstantExecutorExtension
import com.sudzu.trtlmtest.ui.util.MainCoroutineRule
import com.sudzu.trtlmtest.ui.util.TestModelGenerator
import com.sudzu.trtlmtest.utils.BugsSortType
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class MainViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var mockRepository: BugsRepository

    @RelaxedMockK
    private lateinit var mockAppPreferences: AppPreferences

    private lateinit var testViewModel: MainViewModel

    private lateinit var testModelGenerator: TestModelGenerator

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        testModelGenerator = TestModelGenerator()
    }

    @Test
    fun `get bugs list after initialization`() {
        val bug = testModelGenerator.generateBug()
        val list = listOf(bug)
        val notExpectedList = listOf(12345)

        coEvery { mockRepository.getBugs() }.returns(list)

        testViewModel = MainViewModel(mockRepository, mockAppPreferences)

        Assert.assertEquals(testViewModel.bugs.value!!.size, list.size)
        Assert.assertTrue(testViewModel.bugs.value!!.hashCode() == list.hashCode())
        Assert.assertFalse(testViewModel.bugs.value!!.hashCode() == notExpectedList.hashCode())
    }

    @Test
    fun `start checking service after initialization`() {
        testViewModel = MainViewModel(mockRepository, mockAppPreferences)

        val livedataValueAfterInit = testViewModel.startCheckDataService.value!!

        Assert.assertTrue(livedataValueAfterInit)
    }

    @Test
    fun `show bug details onBugClicked`() {
        testViewModel = MainViewModel(mockRepository, mockAppPreferences)
        val testBugId = 123

        testViewModel.onBugItemClicked(testBugId)
        val livedataValueAfterInit = testViewModel.openBugDetails.value!!

        Assert.assertEquals(livedataValueAfterInit, testBugId)
    }

    @Test
    fun `sort values after onSortTypeChanged`() {
        val list = listOf(
            testModelGenerator.generateBug(),
            testModelGenerator.generateBug(),
            testModelGenerator.generateBug()
        )
        val sortType = BugsSortType.BY_ID.ordinal
        val expectedList = list.sortedBy { it.id }

        coEvery { mockRepository.getBugs() }.returns(list)

        testViewModel = MainViewModel(mockRepository, mockAppPreferences)
        testViewModel.onSortTypeChanged(sortType)

        val bugsSorted = testViewModel.bugs.value!!

        Assert.assertEquals(bugsSorted.size, list.size)
        Assert.assertEquals(bugsSorted, expectedList)
    }

    @Test
    fun `show sort dialog onSortButtonClicked`() {
        testViewModel = MainViewModel(mockRepository, mockAppPreferences)
        val testSortType = BugsSortType.BY_ID
        every { mockAppPreferences.getBugsSortType() }.returns(testSortType)

        testViewModel.onSortButtonClicked()
        val livedataValueAfterInit = testViewModel.showSortDialog.value!!

        Assert.assertEquals(livedataValueAfterInit, testSortType.ordinal)
    }

    @Test
    fun `stop checking service after onDestroy`() {
        testViewModel = MainViewModel(mockRepository, mockAppPreferences)

        testViewModel.onDestroy()
        val livedataValueAfterInit = testViewModel.stopCheckDataService.value!!

        Assert.assertTrue(livedataValueAfterInit)
    }


}