package com.yunho.circuitsample.home.screen1

import android.util.Log
import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.home.nested.screen1.NestedScreen1Event
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen1Presenter @AssistedInject constructor(
    @Assisted private val screen: RootScreen.RootGraph.Screen1,
    @Assisted private val navigator: Navigator
) : Presenter<Screen1UiState> {
    @Composable
    override fun present(): Screen1UiState {
        return Screen1UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                Screen1Event.GoToNestedScreen1 -> {
                    navigator.goTo(RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen1())
                }

                Screen1Event.GoToNestedScreen2 -> {
                    navigator.goTo(RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen2())
                }
            }
        }
    }

    @CircuitInject(RootScreen.RootGraph.Screen1::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen2: RootScreen.RootGraph.Screen1,
            navigator: Navigator
        ): Screen1Presenter
    }
}