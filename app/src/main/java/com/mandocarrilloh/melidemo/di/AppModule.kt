package com.mandocarrilloh.melidemo.di

import com.mandocarrilloh.melidemo.ui.flow.home.HomeViewModel
import com.mandocarrilloh.melidemo.ui.flow.home.views.detail.DetailViewModel
import com.mandocarrilloh.melidemo.ui.flow.home.views.search.SearchViewModel
import com.mandocarrilloh.melidemo.ui.flow.home.views.suggestion.SuggestionViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { SearchViewModel(get()) }
    viewModel { DetailViewModel(get(), get()) }
    viewModel { SuggestionViewModel(get()) }
}