package com.yunho.circuitsample.home.nested2

sealed interface ScreenEvent {
    data object GoToNext : ScreenEvent
}