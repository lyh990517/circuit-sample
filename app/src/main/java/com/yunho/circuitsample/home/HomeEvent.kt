package com.yunho.circuitsample.home

sealed interface HomeEvent {
    data object Go : HomeEvent
}