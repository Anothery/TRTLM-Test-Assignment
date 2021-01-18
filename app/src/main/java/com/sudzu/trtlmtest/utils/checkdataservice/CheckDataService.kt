package com.sudzu.trtlmtest.utils.checkdataservice

import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import com.sudzu.trtlmtest.R
import com.sudzu.trtlmtest.data.BugsRepository
import com.sudzu.trtlmtest.utils.toast
import dagger.android.DaggerService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class CheckDataService : DaggerService() {
    companion object {
        const val CHECK_INTERVAL = 30000L
    }

    private val ioScope = CoroutineScope(Dispatchers.IO + Job())

    private val handler = Handler(Looper.getMainLooper())

    private val checkDataTask: Runnable by lazy {
        Runnable {
            ioScope.launch {
                if (bugsRepository.hasNewData()) {
                    handler.post { applicationContext.toast(resources.getString(R.string.service_new_data)) }
                }
                handler.postDelayed(checkDataTask, CHECK_INTERVAL)
            }
        }
    }

    @Inject
    lateinit var bugsRepository: BugsRepository

    override fun onCreate() {
        super.onCreate()
        handler.post(checkDataTask)
    }

    override fun onBind(intent: Intent?): IBinder? = null

}