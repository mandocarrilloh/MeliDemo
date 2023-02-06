package com.mandocarrilloh.melidemo.ui.flow.views

import android.content.Context
import android.util.AttributeSet
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.mandocarrilloh.melidemo.R

class Loading @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private val progressBar = ProgressBar(context)

    init {
        val layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        layoutParams.addRule(CENTER_IN_PARENT, TRUE)
        addView(progressBar, layoutParams)
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorWhiteTransparent))
        isClickable = true
    }

    fun setState(state: Boolean) {
        if (state) {
            showLoading()
        } else {
            hideLoading()
        }
    }

    fun showLoading() {
        this.isVisible = true
        progressBar.isVisible = true
    }

    fun hideLoading() {
        this.isVisible = false
        progressBar.isVisible = false
    }
}
