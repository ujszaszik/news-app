package com.planday.compose.image

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.planday.compose.R
import com.planday.extension.empty

@Composable
fun NetworkImage(url: String?, size: NetworkImageSize) {

    if (url != null) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(url)
                .crossfade(true)
                .placeholder(R.drawable.default_placeholder_image)
                .build(),
            contentDescription = String.empty,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(size.height)
        )
    } else ImagePlaceholder(size.height)

}