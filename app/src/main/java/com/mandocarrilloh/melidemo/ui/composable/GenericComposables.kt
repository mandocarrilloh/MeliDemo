package com.mandocarrilloh.melidemo.ui.composable

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.mandocarrilloh.melidemo.R

@Composable
fun Screen(
    content: @Composable () -> Unit,
) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = colorResource(R.color.colorWhite),
            content = content,
        )
    }
}