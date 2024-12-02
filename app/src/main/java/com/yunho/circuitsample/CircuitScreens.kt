package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

sealed interface CircuitScreens {

    sealed interface HomeGraph : CircuitScreens {
        @Parcelize
        data object NestedScreen1 : HomeGraph, Screen

        @Parcelize
        data object NestedScreen2 : HomeGraph, Screen

        sealed interface NestedGraph : HomeGraph {
            @Parcelize
            data object NestedScreen3 : NestedGraph, Screen

            @Parcelize
            data object NestedScreen4 : NestedGraph, Screen
        }
    }
}