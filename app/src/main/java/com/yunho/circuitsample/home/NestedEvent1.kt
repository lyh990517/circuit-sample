package com.yunho.circuitsample.home

sealed interface NestedEvent1 {
    data object GoToNext : NestedEvent1
}