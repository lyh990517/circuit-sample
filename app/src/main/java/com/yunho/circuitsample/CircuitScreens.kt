package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object RootScreen: Screen {
    sealed interface RootGraph {
        @Parcelize
        data class Screen1(
            val name: String = "screen1",
            val navigationStack: List<String> = listOf()
        ) : RootGraph, Screen

        @Parcelize
        data class Screen2(
            val name: String = "screen2",
            val navigationStack: List<String> = listOf()
        ) : RootGraph, Screen
    }
}