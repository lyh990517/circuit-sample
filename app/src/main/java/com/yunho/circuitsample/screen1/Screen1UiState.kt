package com.yunho.circuitsample.screen1

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen1UiState(
    val data: String,
    val navigationStack: List<Screen>,
    val eventSink: (Screen1Event) -> Unit
) : CircuitUiState