package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data class RootScreen(
    val name: String = "root"
) : Screen {

    @Parcelize
    data class Screen1(
        val name: String = "screen1",
    ) : Screen {

        @Parcelize
        data class NestedScreen1(
            val name: String = "nestedScreen1",
        ) : Screen

        @Parcelize
        data class NestedScreen2(
            val name: String = "nestedScreen2",
        ) : Screen

    }

    @Parcelize
    data class Screen2(
        val name: String = "screen2",
    ) : Screen
}