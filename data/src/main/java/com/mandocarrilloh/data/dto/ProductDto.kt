package com.mandocarrilloh.data.dto

import com.mandocarrilloh.domain.common.EMPTY_STRING
import com.mandocarrilloh.domain.entity.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    @SerialName("id") val id: String? = EMPTY_STRING,
    @SerialName("title") val title: String? = EMPTY_STRING,
    @SerialName("price") val price: Float? = 0F,
    @SerialName("currency_id") val currency_id: String? = EMPTY_STRING,
    @SerialName("thumbnail") val thumbnail: String? = EMPTY_STRING,
    @SerialName("available_quantity") val availableQuantity: Int? = 0,
    @SerialName("sold_quantity") val soldQuantity: Int? = 0,
    @SerialName("condition") val condition: String? = EMPTY_STRING,
    @SerialName("attributes") val attributes: List<AtributesDto>? = null,
    @SerialName("installments") val installments: InstallmentsDto? = null,
    @SerialName("shipping") val shipping: ShippingDto? = null,
    @SerialName("pictures") val pictures: List<PicturesDto>? = null,
    @SerialName("description") val description: String? = EMPTY_STRING,
)

@Serializable
data class AtributesDto(
    @SerialName("name") val name: String? = EMPTY_STRING,
    @SerialName("value_name") val valueName: String? = EMPTY_STRING,
    @SerialName("attribute_group_name") val attributeGroupName: String? = EMPTY_STRING,
)

@Serializable
data class InstallmentsDto(
    @SerialName("quantity") val quantity: Int? = 0,
    @SerialName("amount") val amount: Float? = 0F,
    @SerialName("currency_id") val currencyId: String? = EMPTY_STRING,
)

@Serializable
data class ShippingDto(
    @SerialName("free_shipping") val freeShipping: Boolean?,
    @SerialName("store_pick_up") val storePickUp: Boolean?
)

@Serializable
data class PicturesDto(
    @SerialName("url") val url: String? = EMPTY_STRING,
)

@Serializable
data class DescriptionDto(
    @SerialName("plain_text") val plainText: String? = EMPTY_STRING,
)

fun ProductDto.mapToDomain() = ProductEntity(
    id,
    title,
    price,
    currency_id,
    thumbnail,
    availableQuantity,
    soldQuantity,
    condition,
    attributes?.map { it.mapToDomain() },
    installments?.mapToDomain(),
    shipping?.mapToDomain(),
    pictures?.map { it.mapToDomain() },
)

fun AtributesDto.mapToDomain() = AtributesEntity(
    name,
    valueName,
    attributeGroupName
)

fun InstallmentsDto.mapToDomain() = InstallmentsEntity(
    quantity,
    amount,
    currencyId
)

fun ShippingDto.mapToDomain() = ShippingEntity(
    freeShipping,
    storePickUp
)

fun PicturesDto.mapToDomain() = PicturesEntity(
    url,
)

fun DescriptionDto.mapToDomain() = DescriptionEntity(
    plainText,
)

