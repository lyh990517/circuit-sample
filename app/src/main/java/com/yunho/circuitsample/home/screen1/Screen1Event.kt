package com.yunho.circuitsample.home.screen1

sealed interface Screen1Event {
    data object GoToNestedScreen1 : Screen1Event

    data object GoToNestedScreen2 : Screen1Event
}