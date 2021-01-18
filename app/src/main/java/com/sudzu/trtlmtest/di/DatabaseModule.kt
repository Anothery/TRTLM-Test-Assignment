package com.sudzu.trtlmtest.di

import android.content.Context
import androidx.room.Room
import com.sudzu.trtlmtest.BuildConfig
import com.sudzu.trtlmtest.data.local.BugsDao
import com.sudzu.trtlmtest.data.local.BugsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDeviceDatabase(context: Context): BugsDatabase =
        Room.databaseBuilder(context, BugsDatabase::class.java, BuildConfig.DB_NAME).build()

    @Singleton
    @Provides
    fun provideBugsDao(db: BugsDatabase): BugsDao = db.bugsDao()
}