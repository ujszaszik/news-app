package com.planday.compose.dialog

import androidx.compose.runtime.*

@Composable
fun ErrorDialog(
    title: String,
    message: String,
    onClosed: () -> Unit = {}
) {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        ReposAlertDialog(
            title = title,
            description = message,
            onOkay = {
                showDialog = false
                onClosed.invoke()
            },
        )
    }
}