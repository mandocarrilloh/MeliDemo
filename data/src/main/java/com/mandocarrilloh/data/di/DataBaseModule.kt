package com.mandocarrilloh.data.di

import android.app.Application
import androidx.room.Room
import com.mandocarrilloh.data.room.MeliDatabase
import com.mandocarrilloh.data.room.dao.SearchHistoryDao
import org.koin.dsl.module

/**
 * Provide the Database.
 */

internal val dataBaseModule = module {
    single { provideDataBase(get()) }
    single { provideHistoryDao(get()) }
}

private fun provideDataBase(
    application: Application
): MeliDatabase =
    Room.databaseBuilder(application, MeliDatabase::class.java, "MeliDatabase")
        .fallbackToDestructiveMigration()
        .build()

private fun provideHistoryDao(
    dataBase: MeliDatabase
): SearchHistoryDao = dataBase.searchHistoryDao