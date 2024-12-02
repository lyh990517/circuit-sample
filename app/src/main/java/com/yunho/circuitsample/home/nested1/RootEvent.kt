package com.yunho.circuitsample.home.nested1

sealed interface RootEvent {
    data object GoToNext : RootEvent
}