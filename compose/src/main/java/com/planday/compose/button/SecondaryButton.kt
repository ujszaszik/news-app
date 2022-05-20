package com.planday.compose.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.planday.compose.resources.Colors

@Composable
fun SecondaryButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DefaultButton(
        label = label,
        backgroundColor = Colors.white,
        textColor = Colors.appBlue,
        icon = icon,
        iconTint = Colors.appBlue,
        onClick = onClick
    )
}