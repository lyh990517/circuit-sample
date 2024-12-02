package com.yunho.circuitsample.home.screen2

sealed interface Screen2Event {
    data object GoToNext : Screen2Event
}