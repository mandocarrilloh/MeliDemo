package com.mandocarrilloh.domain.usecase.product

import com.mandocarrilloh.domain.repository.ProductRepository
import kotlinx.coroutines.flow.flow

class GetProductDetail constructor(
    private val repository: ProductRepository,
) {

    fun execute(
        itemId: String,
    ) = flow {
        emit(repository.productDetail(itemId))
    }
}