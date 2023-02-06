package com.mandocarrilloh.data.di

import com.mandocarrilloh.data.api.MeliApi
import org.koin.dsl.module

val dataSourceModule = module {
    single { MeliApi(get(), get()) }
}