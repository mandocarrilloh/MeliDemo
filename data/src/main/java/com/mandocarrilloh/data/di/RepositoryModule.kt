package com.mandocarrilloh.data.di

import com.mandocarrilloh.data.repository.ProductRepositoryImpl
import com.mandocarrilloh.data.repository.SearchHistoryRepositoryImpl
import com.mandocarrilloh.domain.repository.ProductRepository
import com.mandocarrilloh.domain.repository.SearchHistoryRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ProductRepository> { ProductRepositoryImpl(get()) }
    factory<SearchHistoryRepository> { SearchHistoryRepositoryImpl(get()) }
}

