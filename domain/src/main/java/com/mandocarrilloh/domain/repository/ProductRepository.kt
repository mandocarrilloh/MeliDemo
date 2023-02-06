package com.mandocarrilloh.domain.repository

import com.mandocarrilloh.domain.entity.DescriptionEntity
import com.mandocarrilloh.domain.entity.ProductEntity

interface ProductRepository {

    suspend fun searchProducts(query: String): List<ProductEntity>?

    suspend fun productDetail(itemId: String): ProductEntity?

    suspend fun productDescription(itemId: String): DescriptionEntity?

}