package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

sealed interface CircuitScreens {
    @Parcelize
    data object HomeScreen : Screen
}