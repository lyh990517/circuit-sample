package com.yunho.circuitsample.home.screen1

sealed interface ScreenEvent {
    data object GoToNext : ScreenEvent
}