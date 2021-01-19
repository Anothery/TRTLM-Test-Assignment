package com.sudzu.trtlmtest.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sudzu.trtlmtest.data.BugsRepo
import com.sudzu.trtlmtest.ui.bugdetails.BugDetailsViewModel
import com.sudzu.trtlmtest.ui.util.InstantExecutorExtension
import com.sudzu.trtlmtest.ui.util.MainCoroutineRule
import com.sudzu.trtlmtest.ui.util.TestModelGenerator
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.ObsoleteCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantExecutorExtension::class)
class BugDetailsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @RelaxedMockK
    private lateinit var mockRepository: BugsRepo

    private lateinit var testViewModel: BugDetailsViewModel

    private lateinit var testModelGenerator: TestModelGenerator

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        testModelGenerator = TestModelGenerator()
    }

    @Test
    fun `get bug details`() {
        val bug = testModelGenerator.generateBug()
        val notExpectedBug = testModelGenerator.generateBug()
        val testBugId = 123

        coEvery { mockRepository.getBug(testBugId) }.returns(bug)

        testViewModel = BugDetailsViewModel(mockRepository)
        testViewModel.onBugIdCatched(testBugId)


        Assert.assertTrue(testViewModel.details.value!! == bug)
        Assert.assertFalse(testViewModel.details.value!! == notExpectedBug)
    }
}