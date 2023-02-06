package com.mandocarrilloh.melidemo.ui.item_views

import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.databinding.ItemViewImageDetailBinding
import com.mandocarrilloh.melidemo.ui.flow.home.views.search.binding.setImage
import com.xwray.groupie.databinding.BindableItem

class ImageDetaiItemView(
    private val image: String,
    private val count: Int
) : BindableItem<ItemViewImageDetailBinding>() {

    override fun bind(viewBinding: ItemViewImageDetailBinding, position: Int) {
        setImage(viewBinding.imageView, image)
        viewBinding.textViewCount.text = (position + 1).toString() + "/" + count.toString()
    }

    override fun getLayout() = R.layout.item_view_image_detail
}