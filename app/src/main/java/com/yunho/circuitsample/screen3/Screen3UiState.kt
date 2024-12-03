package com.yunho.circuitsample.screen3

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class Screen3UiState(
    val navigationStack: List<Screen>,
    val eventSink: (Screen3Event) -> Unit
) : CircuitUiState