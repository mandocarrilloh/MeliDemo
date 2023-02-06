package com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.util.Util
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SuggestionFragment : BaseFragment() {

    private val viewModel by sharedViewModel<SuggestionViewModel>()

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        setStatusBarColor(R.color.colorPrimary)
        return ComposeView(requireContext()).apply {
            isTransitionGroup = true
            setContent {
                val state by viewModel.state.collectAsState()
                SuggestionComposable(
                    state,
                    handleEvent = ::handleEvent
                )
            }
        }.also {
            viewModel.state.handleEvent(SuggestionEvent.Init)
        }
    }

    private fun handleEvent(event: SuggestionEvent) {
        when(event) {
            is SuggestionEvent.Back -> findNavController().popBackStack()
            is SuggestionEvent.SuggestionClicked -> {
                viewModel.setSuggestionSelected(event.suggestion.searchWord)
                findNavController().popBackStack()
            }
            is SuggestionEvent.SuggestionInput -> {
                viewModel.setSuggestionSelected(event.input)
                findNavController().popBackStack()
            }
            else -> viewModel.state.handleEvent(event)
        }
    }
}