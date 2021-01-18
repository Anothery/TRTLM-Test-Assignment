package com.sudzu.trtlmtest.di

import androidx.lifecycle.ViewModel
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.data.local.MainAppPreferences
import com.sudzu.trtlmtest.ui.bugdetails.BugDetailsViewModel
import com.sudzu.trtlmtest.ui.main.MainViewModel
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
class ViewModelModule {

    @Target(
        AnnotationTarget.FUNCTION,
        AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.PROPERTY_SETTER
    )
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal fun provideMainViewModel(
        bugsRepository: BugsRepository,
        mainAppPreferences: MainAppPreferences
    ): ViewModel =
        MainViewModel(bugsRepository, mainAppPreferences)

    @Provides
    @IntoMap
    @ViewModelKey(BugDetailsViewModel::class)
    internal fun provideBugDetailsViewModel(bugsRepository: BugsRepository): ViewModel =
        BugDetailsViewModel(bugsRepository)

}

