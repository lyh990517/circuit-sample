package com.yunho.circuitsample.root

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen

data class RootUiState(
    val displayedScreen: Screen,
    val eventSink: (RootEvent) -> Unit
) : CircuitUiState