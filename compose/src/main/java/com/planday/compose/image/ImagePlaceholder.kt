package com.planday.compose.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.planday.compose.R
import com.planday.extension.empty

@Composable
fun ImagePlaceholder(height: Dp) {
    Image(
        painter = painterResource(R.drawable.default_placeholder_image),
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        contentDescription = String.empty
    )
}