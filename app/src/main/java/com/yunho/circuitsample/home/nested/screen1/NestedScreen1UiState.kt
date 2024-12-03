package com.yunho.circuitsample.home.nested.screen1

import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import com.yunho.circuitsample.home.nested.screen1.NestedScreen1Event

data class NestedScreen1UiState(
    val navigationStack: List<Screen>,
    val eventSink: (NestedScreen1Event) -> Unit
) : CircuitUiState