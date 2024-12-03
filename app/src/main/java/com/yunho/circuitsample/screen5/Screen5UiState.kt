package com.yunho.circuitsample.screen5

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen5UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen5Event) -> Unit
) : CircuitUiState