package com.sudzu.trtlmtest.di

import com.sudzu.trtlmtest.data.BugsDataRepository
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.data.local.BugsDao
import com.sudzu.trtlmtest.data.network.BugsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, NetworkModule::class])
class DataModule {
    @Singleton
    @Provides
    fun provideUsersRepository(api: BugsApi, bugsDao: BugsDao): BugsRepository =
        BugsDataRepository(api, bugsDao)
}