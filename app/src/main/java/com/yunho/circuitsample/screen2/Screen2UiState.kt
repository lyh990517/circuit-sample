package com.yunho.circuitsample.screen2

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen2UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen2Event) -> Unit
) : CircuitUiState