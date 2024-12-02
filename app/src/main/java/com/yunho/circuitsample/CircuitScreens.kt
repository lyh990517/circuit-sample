package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

sealed interface CircuitScreens {

    sealed interface HomeGraph : CircuitScreens {
        @Parcelize
        data class RootScreen(
            val name: String = "root",
            val navigationStack: List<String> = listOf()
        ) : HomeGraph, Screen

        @Parcelize
        data class Screen1(
            val name: String = "screen1",
            val navigationStack: List<String> = listOf()
        ) : HomeGraph, Screen

        @Parcelize
        data class Screen2(
            val name: String = "screen2",
            val navigationStack: List<String> = listOf()
        ) : HomeGraph, Screen

        sealed interface NestedGraph : HomeGraph {
            @Parcelize
            data class NestedScreen3(
                val name: String,
                val navigationStack: List<String> = listOf()
            ) : NestedGraph, Screen

            @Parcelize
            data class NestedScreen4(
                val name: String,
                val navigationStack: List<String> = listOf()
            ) : NestedGraph, Screen
        }
    }
}