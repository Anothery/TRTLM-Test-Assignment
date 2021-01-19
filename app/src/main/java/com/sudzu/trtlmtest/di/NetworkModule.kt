package com.sudzu.trtlmtest.di

import com.google.gson.GsonBuilder
import com.sudzu.trtlmtest.BuildConfig
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.data.BugsDataRepository
import com.sudzu.trtlmtest.data.local.BugsDao
import com.sudzu.trtlmtest.data.network.BugsApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .baseUrl(BuildConfig.BUGZILLA_API_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()


    @Singleton
    @Provides
    fun provideUsersApi(retrofit: Retrofit): BugsApi = retrofit.create(BugsApi::class.java)
}