package com.yunho.circuitsample.screen1

sealed interface Screen1Event {
    data object GoToScreen3 : Screen1Event

    data object GoToScreen4 : Screen1Event
}