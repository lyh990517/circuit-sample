package com.yunho.circuitsample.home

import com.slack.circuit.runtime.CircuitUiState

data class NestedUiState1(
    val eventSink: (NestedEvent1) -> Unit
) : CircuitUiState