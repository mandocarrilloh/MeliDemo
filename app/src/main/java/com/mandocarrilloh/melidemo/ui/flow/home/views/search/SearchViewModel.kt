package com.mandocarrilloh.melidemo.ui.flow.home.views.search

import android.os.Bundle
import android.text.Editable
import androidx.lifecycle.MutableLiveData
import com.mandocarrilloh.domain.common.EMPTY_STRING
import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.domain.usecase.product.GetSearchProducts
import com.mandocarrilloh.melidemo.ui.base.BaseViewModel
import com.mandocarrilloh.melidemo.ui.extensions.asLiveData
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

private const val KEY_PRODUCTS = "KEY_PRODUCTS"
private const val SEARCH_PAUSE = 300L
private const val SEARCH_LENGTH = 2

class SearchViewModel constructor(
    private val getSearchProducts: GetSearchProducts
) : BaseViewModel() {

    private var searchJob: Job? = null

    /**
     * event
     * */

    private val _products = MutableLiveData<List<ProductEntity>>()
    val products = _products.asLiveData()

    /**
     * init
     * */

    fun getSearchProducts(search: String) {
        searchJob?.cancel()
        searchJob = execute {
            delay(SEARCH_PAUSE)
            if (search.length >= SEARCH_LENGTH) {
                _loader.value = true
                getSearchProducts.execute(search).collectLatest { data ->
                    _products.value = data
                }
                _loader.value = false
            }
        }
    }

    /**
     * Overrides
     */

    override fun onSaveInstanceState() = Bundle().apply {
        _products.value?.let { putParcelableArrayList(KEY_PRODUCTS, ArrayList(it)) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        _products.value =
            savedInstanceState.getParcelableArrayList<ProductEntity?>(KEY_PRODUCTS).orEmpty()
    }
}