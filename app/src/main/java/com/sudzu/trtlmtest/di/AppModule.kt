package com.sudzu.trtlmtest.di

import android.app.Application
import android.content.Context
import com.sudzu.trtlmtest.data.local.AppPreferences
import com.sudzu.trtlmtest.data.local.MainAppPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelFactoryModule::class, ViewModelModule::class, DatabaseModule::class, NetworkModule::class, ServiceModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideAppPreferences(context: Context): AppPreferences = MainAppPreferences(context)
}