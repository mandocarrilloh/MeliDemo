package com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mandocarrilloh.domain.usecase.searchHistory.GetSearchHistory
import com.mandocarrilloh.melidemo.ui.base.BaseViewModel
import com.mandocarrilloh.melidemo.ui.extensions.asLiveData
import com.mandocarrilloh.melidemo.ui.lifecycle.StateReducerFlow
import kotlinx.coroutines.flow.collectLatest

class SuggestionViewModel constructor(
    private val getSearchHistory: GetSearchHistory,
) : BaseViewModel() {

    /**
     * Events
     */

    private val _suggestionSelected = MutableLiveData<String>()
    val suggestionSelected = _suggestionSelected.asLiveData()

    val state = StateReducerFlow(
        initialState = SuggestionState(),
        reduceState = ::reduceState,
    )

    /**
     * Actions
     */

    fun setSuggestionSelected(
        suggestion: String
    ) {
        _suggestionSelected.value = suggestion
    }

    /**
     * Validations
     */

    private fun reduceState(
        currentState: SuggestionState,
        event: SuggestionEvent
    ): SuggestionState = when (event) {
        is SuggestionEvent.Init, SuggestionEvent.RefreshSwiped -> {
            getSuggestionLocal()
            currentState.copy(isLoading = true)
        }
        is SuggestionEvent.Loaded -> currentState.copy(
            isLoading = false,
            suggestion = event.suggestions
        )
        is SuggestionEvent.Error -> currentState.copy(isLoading = true)
        else -> currentState
    }

    private fun getSuggestionLocal() = execute {
        getSearchHistory.execute()
            .collectLatest {
                val event = SuggestionEvent.Loaded(it.orEmpty())
                state.handleEvent(event)
            }
    }
}