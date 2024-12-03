package com.yunho.circuitsample.screen2

sealed interface Screen2Event {
    data object GoToNext : Screen2Event
}