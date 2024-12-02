package com.yunho.circuitsample.home

import com.slack.circuit.runtime.CircuitUiState

data class HomeUiState(
    val eventSink: (HomeEvent) -> Unit
) : CircuitUiState