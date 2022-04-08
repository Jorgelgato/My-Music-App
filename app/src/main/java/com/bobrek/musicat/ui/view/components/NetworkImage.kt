package com.bobrek.musicat.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun NetworkImage(url: String?, size: Size = Size.MEDIUM) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        modifier = Modifier.size(size.dp)
    )
}

enum class Size(val dp: Dp) {
    MEDIUM(72.dp),
    SMALL(48.dp)
}