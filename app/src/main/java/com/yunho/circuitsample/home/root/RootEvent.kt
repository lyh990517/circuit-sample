package com.yunho.circuitsample.home.root

import com.slack.circuit.foundation.NavEvent

sealed interface RootEvent {
    data class NestedNavEvent(val navEvent: NavEvent) : RootEvent
}