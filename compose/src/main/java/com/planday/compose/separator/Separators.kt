package com.planday.compose.separator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.planday.compose.resources.Colors
import com.planday.compose.resources.Dimens

@Composable
fun VerticalSeparator() {
    Divider(
        modifier = Modifier
            .padding(Dimens.paddingDefault)
            .height(Dimens.defaultSeparatorHeight)
            .background(Colors.gray)
    )
}