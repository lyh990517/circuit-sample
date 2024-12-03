package com.yunho.circuitsample.home.root

import com.slack.circuit.foundation.NavEvent
import com.slack.circuit.runtime.screen.Screen

sealed interface RootEvent {
    data class ChangeScreen(val screen: Screen) : RootEvent
    data class NestedNavEvent(val navEvent: NavEvent) : RootEvent
}