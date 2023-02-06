package com.mandocarrilloh.domain.usecase.searchHistory

import com.mandocarrilloh.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.flow

class GetSearchHistory constructor(
    private val repository: SearchHistoryRepository,
) {

    fun execute() = flow {
        emit(repository.getSearchHistory())
    }
}