package com.mandocarrilloh.melidemo.utils

import android.content.Context
import com.mandocarrilloh.melidemo.R
import java.text.NumberFormat
import java.util.*

class MoneyFormatter constructor(
    private val context: Context
) {

    private val locale = Locale.GERMANY

    fun format(value: Number) =
        context.resources.getString(
            R.string.format_money,
            NumberFormat.getIntegerInstance(locale).format(value)
        )
}