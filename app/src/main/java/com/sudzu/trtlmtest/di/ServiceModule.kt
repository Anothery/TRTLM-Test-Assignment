package com.sudzu.trtlmtest.di

import com.sudzu.trtlmtest.utils.checkdataservice.CheckDataService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule {
    @ContributesAndroidInjector
    abstract fun provideCheckDataService(): CheckDataService
}