package com.mandocarrilloh.data.api

import com.mandocarrilloh.data.dto.BaseResponseDto
import com.mandocarrilloh.data.dto.DescriptionDto
import com.mandocarrilloh.data.dto.ProductDto
import com.mandocarrilloh.domain.common.*
import io.ktor.client.*
import io.ktor.client.request.*

class MeliApi constructor(
    private val baseUrl: String,
    private val httpClient: HttpClient,
) {

    suspend fun searchProducts(query: String): List<ProductDto> =
        httpClient.get<BaseResponseDto<List<ProductDto>>> {
            url("$baseUrl$URL_SITES$URL_SITE_CO$URL_SEARCH")
            parameter("q", query)
        }.results

    suspend fun productDetail(itemId: String): ProductDto? =
        httpClient.get {
            url("$baseUrl$URL_ITEMS/$itemId")
        }

    suspend fun productDescription(itemId: String): DescriptionDto? =
        httpClient.get {
            url("$baseUrl$URL_ITEMS/$itemId$URL_DESCRIPTION")
        }
}