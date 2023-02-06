package com.mandocarrilloh.melidemo.ui.flow.home.views.detail

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.domain.usecase.product.GetProductDescription
import com.mandocarrilloh.domain.usecase.product.GetProductDetail
import com.mandocarrilloh.melidemo.ui.base.BaseViewModel
import com.mandocarrilloh.melidemo.ui.extensions.asLiveData
import kotlinx.coroutines.flow.collectLatest

private const val KEY_PRODUCT = "KEY_PRODUCT"

class DetailViewModel constructor(
    private val getProductDetail: GetProductDetail,
    private val getProductDescription: GetProductDescription,
) : BaseViewModel() {

    /**
     * event
     * */

    private val _product = MutableLiveData<ProductEntity>()
    val product = _product.asLiveData()

    private val _description= MutableLiveData<String>()
    val description = _description.asLiveData()

    /**
     * init
     * */

    fun init(itemId: String) {
        getInfoProduct(itemId)
    }

    private fun getInfoProduct(itemId: String) = execute {
        _loader.value = true
        getProductDetail.execute(itemId).collectLatest { data ->
            _product.value = data
        }
        getProductDescription.execute(itemId).collectLatest { description ->
            _description.value = description?.plainText
        }
        _loader.value = false
    }

    /**
     * Overrides
     */

    override fun onSaveInstanceState() = Bundle().apply {
        _product.value?.let { putParcelable(KEY_PRODUCT, it) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        _product.value = savedInstanceState.getParcelable(KEY_PRODUCT)
    }
}