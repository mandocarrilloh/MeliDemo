package com.mandocarrilloh.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuggestionEntity(
    val searchWord: String,
) : Parcelable