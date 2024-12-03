package com.yunho.circuitsample.screen4

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen4UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen4Event) -> Unit
) : CircuitUiState