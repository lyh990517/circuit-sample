package com.yunho.circuitsample.home.nested.screen2

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class NestedScreen2UiState(
    val navigationStack: List<Screen>,
    val eventSink: (NestedScreen2Event) -> Unit
) : CircuitUiState