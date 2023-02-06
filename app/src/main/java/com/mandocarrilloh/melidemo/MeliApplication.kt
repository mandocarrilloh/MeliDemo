package com.mandocarrilloh.melidemo

import android.app.Application
import com.mandocarrilloh.data.di.dataModule
import com.mandocarrilloh.domain.di.domainModule
import com.mandocarrilloh.melidemo.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MeliApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() = startKoin {
        androidContext(this@MeliApplication)
        modules(listOf(appModule, dataModule, domainModule))
    }
}