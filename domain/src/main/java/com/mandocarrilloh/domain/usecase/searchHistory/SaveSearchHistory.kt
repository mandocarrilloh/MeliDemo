package com.mandocarrilloh.domain.usecase.searchHistory

import com.mandocarrilloh.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.flow

class SaveSearchHistory constructor(
    private val repository: SearchHistoryRepository,
) {

    fun execute(
        search: String
    ) = flow {
        emit(repository.saveSearchHistory(search))
    }
}