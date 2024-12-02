package com.yunho.circuitsample.home.root

import com.slack.circuit.runtime.CircuitUiState

data class RootUiState(
    val name: String,
    val eventSink: (RootEvent) -> Unit
) : CircuitUiState