package com.mandocarrilloh.domain.usecase.product

import com.mandocarrilloh.domain.repository.ProductRepository
import com.mandocarrilloh.domain.repository.SearchHistoryRepository
import kotlinx.coroutines.flow.flow

class GetSearchProducts constructor(
    private val repository: ProductRepository,
    private val repositorySearch: SearchHistoryRepository,
) {

    fun execute(
        query: String,
    ) = flow {
        try {
            repositorySearch.saveSearchHistory(query)
            emit(repository.searchProducts(query))
        } catch (e: Exception) {
            emit(listOf())
        }
    }
}