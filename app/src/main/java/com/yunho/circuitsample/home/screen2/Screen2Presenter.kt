package com.yunho.circuitsample.home.screen2

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen2
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen2Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen2,
    @Assisted private val navigator: Navigator
) : Presenter<Screen2UiState> {
    @Composable
    override fun present(): Screen2UiState {
        return Screen2UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                Screen2Event.GoToNext -> {}
            }
        }
    }

    @CircuitInject(Screen2::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen2,
            navigator: Navigator
        ): Screen2Presenter
    }
}