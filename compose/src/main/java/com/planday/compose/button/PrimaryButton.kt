package com.planday.compose.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.planday.compose.resources.Colors

@Composable
fun PrimaryButton(
    label: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    DefaultButton(
        label = label,
        backgroundColor = Colors.appBlue,
        textColor = Colors.white,
        icon = icon,
        iconTint = Colors.white,
        onClick = onClick
    )
}