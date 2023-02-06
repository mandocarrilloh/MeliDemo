package com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion

import com.mandocarrilloh.domain.entity.SuggestionEntity


sealed class SuggestionEvent {

    object Init : SuggestionEvent()

    object Back : SuggestionEvent()

    object RefreshSwiped : SuggestionEvent()

    data class SuggestionClicked(val suggestion: SuggestionEntity) : SuggestionEvent()

    data class SuggestionInput(val input: String) : SuggestionEvent()

    data class Loaded(val suggestions: List<SuggestionEntity>) : SuggestionEvent()

    data class Error(val error: Exception) : SuggestionEvent()
}
