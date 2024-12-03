package com.yunho.circuitsample.screen3

sealed interface Screen3Event {
    data class PopResult(val data: String) : Screen3Event
}