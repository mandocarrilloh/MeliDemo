package com.mandocarrilloh.data.repository

import com.mandocarrilloh.data.api.MeliApi
import com.mandocarrilloh.data.dto.mapToDomain
import com.mandocarrilloh.domain.entity.DescriptionEntity
import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.domain.repository.ProductRepository

class ProductRepositoryImpl constructor(
    private val meliApi: MeliApi,
) : ProductRepository {

    override suspend fun searchProducts(query: String): List<ProductEntity> =
        meliApi.searchProducts(query).map { it.mapToDomain() }

    override suspend fun productDetail(itemId: String): ProductEntity? =
        meliApi.productDetail(itemId)?.mapToDomain()

    override suspend fun productDescription(itemId: String): DescriptionEntity? =
        meliApi.productDescription(itemId)?.mapToDomain()

}