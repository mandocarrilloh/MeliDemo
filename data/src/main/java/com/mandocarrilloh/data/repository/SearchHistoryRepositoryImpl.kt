package com.mandocarrilloh.data.repository

import com.mandocarrilloh.data.room.dao.SearchHistoryDao
import com.mandocarrilloh.domain.entity.SuggestionEntity
import com.mandocarrilloh.domain.repository.SearchHistoryRepository

class SearchHistoryRepositoryImpl constructor(
    private val searchHistoryDao: SearchHistoryDao,
) : SearchHistoryRepository {

    override suspend fun getSearchHistory(): List<SuggestionEntity> =
        searchHistoryDao.getSearchHistory()?.map { SuggestionEntity(it.searchWord) }.orEmpty()

    override suspend fun saveSearchHistory(search: String) =
        searchHistoryDao.insertRecord(search)

}