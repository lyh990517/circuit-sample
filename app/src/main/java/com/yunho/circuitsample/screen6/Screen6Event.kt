package com.yunho.circuitsample.screen6

import com.slack.circuit.foundation.NavEvent
import com.slack.circuit.runtime.screen.Screen

sealed interface Screen6Event {
    data class ChangeScreen(val screen: Screen) : Screen6Event
    data class NestedNavEvent(val navEvent: NavEvent) : Screen6Event
}