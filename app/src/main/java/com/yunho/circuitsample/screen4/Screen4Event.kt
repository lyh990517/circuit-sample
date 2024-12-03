package com.yunho.circuitsample.screen4

import com.slack.circuit.foundation.NavEvent
import com.slack.circuit.runtime.screen.Screen
import com.yunho.circuitsample.root.RootEvent

sealed interface Screen4Event {
    data class ChangeScreen(val screen: Screen) : Screen4Event
    data class NestedNavEvent(val navEvent: NavEvent) : Screen4Event
}