package com.mandocarrilloh.data.room.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SearchHistoryDbDto")
data class SearchHistoryDbDto(
    @PrimaryKey val searchWord: String
)