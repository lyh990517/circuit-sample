package com.yunho.circuitsample

import com.slack.circuit.runtime.screen.Screen
import kotlinx.parcelize.Parcelize

@Parcelize
data class RootScreen(
    val name: String = "root"
) : Screen

@Parcelize
data class Screen1(
    val name: String = "screen1",
) : Screen

@Parcelize
data class Screen2(
    val name: String = "screen2",
) : Screen

@Parcelize
data class Screen3(
    val name: String = "screen3",
) : Screen

@Parcelize
data class Screen4(
    val name: String = "screen4",
) : Screen

@Parcelize
data class Screen5(
    val name: String = "screen5",
) : Screen

@Parcelize
data class Screen6(
    val name: String = "screen6",
) : Screen

@Parcelize
data class Screen7(
    val name: String = "screen7",
) : Screen
