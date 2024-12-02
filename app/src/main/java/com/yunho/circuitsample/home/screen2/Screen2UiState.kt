package com.yunho.circuitsample.home.screen2

import com.slack.circuit.runtime.CircuitUiState

data class Screen2UiState(
    val navigationStack: List<String>,
    val eventSink: (Screen2Event) -> Unit
) : CircuitUiState