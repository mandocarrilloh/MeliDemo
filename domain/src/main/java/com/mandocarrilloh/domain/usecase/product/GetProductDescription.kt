package com.mandocarrilloh.domain.usecase.product

import com.mandocarrilloh.domain.repository.ProductRepository
import kotlinx.coroutines.flow.flow

class GetProductDescription constructor(
    private val repository: ProductRepository,
) {

    fun execute(
        itemId: String,
    ) = flow {
        emit(repository.productDescription(itemId))
    }
}