package com.mandocarrilloh.data.di

import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val dataModule = module {
    loadKoinModules(
        listOf(
            dataBaseModule,
            networkModule,
            dataSourceModule,
            repositoryModule,
        )
    )
}