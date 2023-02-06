package com.mandocarrilloh.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponseDto<T>(
    @SerialName("results") val results: T,
    @SerialName("paging") val paging: PagingResponseDto,
)

@Serializable
data class PagingResponseDto(
    @SerialName("total") val total: Int,
    @SerialName("primary_results") val primaryResults: Int,
    @SerialName("offset") val offset: Int,
    @SerialName("limit") val limit: Int,
)