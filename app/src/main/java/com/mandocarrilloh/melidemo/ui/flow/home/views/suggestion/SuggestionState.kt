package com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion

import com.mandocarrilloh.domain.entity.SuggestionEntity

data class SuggestionState(
    val isLoading: Boolean = false,
    val suggestion: List<SuggestionEntity> = emptyList(),
)