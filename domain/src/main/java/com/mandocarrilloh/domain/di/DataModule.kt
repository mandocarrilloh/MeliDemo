package com.mandocarrilloh.domain.di

import com.mandocarrilloh.domain.usecase.product.GetProductDescription
import com.mandocarrilloh.domain.usecase.product.GetProductDetail
import com.mandocarrilloh.domain.usecase.product.GetSearchProducts
import com.mandocarrilloh.domain.usecase.searchHistory.GetSearchHistory
import com.mandocarrilloh.domain.usecase.searchHistory.SaveSearchHistory
import org.koin.dsl.module

val domainModule = module {
    single { GetSearchProducts(get(), get()) }
    single { GetProductDetail(get()) }
    single { GetProductDescription(get()) }
    single { SaveSearchHistory(get()) }
    single { GetSearchHistory(get()) }
}