package com.planday.newsapp.features.main.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

object ActionBarChannel : CoroutineScope {

    override val coroutineContext = Dispatchers.Main

    private val channel = Channel<ActionBarEvent?>()

    private var currentValue: ActionBarEvent? = null

    fun receive() = channel.receiveAsFlow()

    fun navigateToSearchPage() {
        launch {
            currentValue = ActionBarEvent.NavigateToSearchPage
            channel.send(currentValue)
        }
    }

    fun closeApplication() {
        launch {
            currentValue = ActionBarEvent.CloseApplication
            channel.send(currentValue)
        }
    }

    fun reset() = launch {
        currentValue = null
        channel.send(currentValue)
    }
}

sealed class ActionBarEvent {
    object NavigateToSearchPage : ActionBarEvent()
    object CloseApplication : ActionBarEvent()
}