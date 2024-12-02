package com.yunho.circuitsample.home.screen1

import com.slack.circuit.runtime.CircuitUiState

data class Screen1UiState(
    val navigationStack: List<String>,
    val eventSink: (ScreenEvent) -> Unit
) : CircuitUiState