package com.sudzu.trtlmtest.di

import com.sudzu.trtlmtest.ui.bugdetails.BugDetailsActivity
import com.sudzu.trtlmtest.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {
    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun provideBugDetailsActivity(): BugDetailsActivity
}