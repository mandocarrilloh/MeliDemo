package com.mandocarrilloh.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductEntity(
    val id: String?,
    val title: String?,
    val price: Float?,
    val currency_id: String?,
    val thumbnail: String?,
    val availableQuantity: Int?,
    val soldQuantity: Int?,
    val condition: String?,
    val attributes: List<AtributesEntity>?,
    val installments: InstallmentsEntity?,
    val shipping: ShippingEntity?,
    val pictures: List<PicturesEntity>?,
) : Parcelable

@Parcelize
data class AtributesEntity(
    val name: String?,
    val valueName: String?,
    val attributeGroupName: String?
) : Parcelable

@Parcelize
data class InstallmentsEntity(
    val quantity: Int?,
    val amount: Float?,
    val currencyId: String?
) : Parcelable

@Parcelize
data class ShippingEntity(
    val freeShipping: Boolean?,
    val storePickUp: Boolean?
) : Parcelable

@Parcelize
data class PicturesEntity(
    val url: String?,
) : Parcelable

@Parcelize
data class DescriptionEntity(
    val plainText: String?,
) : Parcelable