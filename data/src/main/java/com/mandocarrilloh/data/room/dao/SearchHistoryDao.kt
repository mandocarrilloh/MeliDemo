package com.mandocarrilloh.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.mandocarrilloh.data.room.tables.SearchHistoryDbDto

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM SearchHistoryDbDto")
    suspend fun getSearchHistory(): List<SearchHistoryDbDto>?

    @Query("INSERT OR REPLACE INTO SearchHistoryDbDto(searchWord) VALUES (:search)")
    suspend fun insertRecord(search: String)
}
