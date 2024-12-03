package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data object RootScreen : Screen {
    sealed interface RootGraph {

        @Parcelize
        data class Screen1(
            val name: String = "screen1",
        ) : RootGraph, Screen {

            sealed interface Screen1Graph : RootGraph {
                @Parcelize
                data class NestedScreen1(
                    val name: String = "nestedScreen1",
                ) : Screen1Graph, Screen

                @Parcelize
                data class NestedScreen2(
                    val name: String = "nestedScreen2",
                ) : Screen1Graph, Screen
            }
        }

        @Parcelize
        data class Screen2(
            val name: String = "screen2",
        ) : RootGraph, Screen
    }
}