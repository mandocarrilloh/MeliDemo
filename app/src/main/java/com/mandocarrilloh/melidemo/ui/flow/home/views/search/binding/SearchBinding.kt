package com.mandocarrilloh.melidemo.ui.flow.home.views.search.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mandocarrilloh.domain.common.HTTPS
import com.mandocarrilloh.melidemo.R
import com.mandocarrilloh.melidemo.utils.MoneyFormatter

@BindingAdapter("price")
fun setPrice(
    textView: TextView,
    price: Float,
) = textView.run {
    val context = context
    val moneyFormatter = MoneyFormatter(context)
    text = moneyFormatter.format(price)
}

@BindingAdapter("quantity", "amount")
fun setInstallments(
    textView: TextView,
    quantity: Int,
    amount: Float,
) = textView.run {
    val context = context
    val moneyFormatter = MoneyFormatter(context)
    text = context.getString(
        R.string.copy_installments,
        quantity,
        moneyFormatter.format(amount)
    )
}

@BindingAdapter("isFree")
fun showView(textView: TextView, isFree: Boolean?) =
    textView.run {
        isVisible = isFree == true
    }

@BindingAdapter("available")
fun setAvailable(textView: TextView, available: Int?) =
    textView.run {
        isVisible = available != null
        text = context.getString(
            R.string.copy_available,
            available,
        )
    }

@BindingAdapter("load_image")
fun setImage(imageView: ImageView, imagePath: String?) {
    Glide.with(imageView.context)
        .load(imagePath?.replaceRange(0..3, HTTPS))
        .fitCenter()
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(imageView)
}