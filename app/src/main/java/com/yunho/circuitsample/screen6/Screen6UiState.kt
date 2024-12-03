package com.yunho.circuitsample.screen6

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen6UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen6Event) -> Unit
) : CircuitUiState