package com.yunho.circuitsample.home.nested.screen2

sealed interface NestedScreen2Event {
    data object GoToNext : NestedScreen2Event
}