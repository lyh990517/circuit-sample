package com.yunho.circuitsample.home.screen1

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen1
import com.yunho.circuitsample.Screen3
import com.yunho.circuitsample.Screen4
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen1Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen1,
    @Assisted private val navigator: Navigator
) : Presenter<Screen1UiState> {
    @Composable
    override fun present(): Screen1UiState {
        return Screen1UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                Screen1Event.GoToScreen3 -> {
                    navigator.goTo(Screen3())
                }

                Screen1Event.GoToScreen4 -> {
                    navigator.goTo(Screen4())
                }
            }
        }
    }

    @CircuitInject(Screen1::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen2: Screen1,
            navigator: Navigator
        ): Screen1Presenter
    }
}