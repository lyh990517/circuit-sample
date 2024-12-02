package com.yunho.circuitsample.home.nested1

import com.slack.circuit.runtime.CircuitUiState

data class RootUiState(
    val name: String,
    val eventSink: (RootEvent) -> Unit
) : CircuitUiState