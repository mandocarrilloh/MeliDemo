package com.mandocarrilloh.melidemo.ui.item_views

import com.mandocarrilloh.domain.entity.ProductEntity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.ItemViewProductBinding
import com.xwray.groupie.databinding.BindableItem

class ProductItemView(
    private val product: ProductEntity,
    private val action: (ProductEntity) -> Unit,
) : BindableItem<ItemViewProductBinding>() {

    override fun bind(viewBinding: ItemViewProductBinding, position: Int) {
        viewBinding.data = product
        viewBinding.root.setOnClickListener { action(product) }
    }

    override fun getLayout() = R.layout.item_view_product
}