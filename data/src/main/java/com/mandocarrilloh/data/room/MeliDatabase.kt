package com.mandocarrilloh.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mandocarrilloh.data.room.dao.SearchHistoryDao
import com.mandocarrilloh.data.room.tables.SearchHistoryDbDto

@Database(
    entities = [
        SearchHistoryDbDto::class,
    ],
    version = 2,
    exportSchema = false
)
abstract class MeliDatabase : RoomDatabase() {

    abstract val searchHistoryDao: SearchHistoryDao
}