package com.mandocarrilloh.melidemo.ui.item_views

import com.mandocarrilloh.domain.entity.AtributesEntity
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.ItemViewAttributeBinding
import com.xwray.groupie.databinding.BindableItem

class AttributeItemView(
    private val attributes: AtributesEntity,
) : BindableItem<ItemViewAttributeBinding>() {

    override fun bind(viewBinding: ItemViewAttributeBinding, position: Int) {
        viewBinding.textViewAttributes.text = attributes.name
        viewBinding.textViewValue.text = attributes.valueName
    }

    override fun getLayout() = R.layout.item_view_attribute
}