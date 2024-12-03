package com.yunho.circuitsample.screen7

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen7UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen7Event) -> Unit
) : CircuitUiState