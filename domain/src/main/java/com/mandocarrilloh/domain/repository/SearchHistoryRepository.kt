package com.mandocarrilloh.domain.repository

import com.mandocarrilloh.domain.entity.SuggestionEntity

interface SearchHistoryRepository {

    suspend fun getSearchHistory(): List<SuggestionEntity>?

    suspend fun saveSearchHistory(search: String)
}