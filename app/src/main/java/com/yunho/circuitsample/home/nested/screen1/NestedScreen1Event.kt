package com.yunho.circuitsample.home.nested.screen1

sealed interface NestedScreen1Event {
    data object GoToNestedScreen1 : NestedScreen1Event

    data object GoToNestedScreen2 : NestedScreen1Event
}