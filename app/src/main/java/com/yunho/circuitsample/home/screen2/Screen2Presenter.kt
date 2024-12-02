package com.yunho.circuitsample.home.screen2

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.RootScreen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen2Presenter @AssistedInject constructor(
    @Assisted private val screen: RootScreen.RootGraph.Screen2,
    @Assisted private val navigator: Navigator
) : Presenter<Screen2UiState> {
    @Composable
    override fun present(): Screen2UiState {
        return Screen2UiState(
            navigationStack = listOf(screen.name) + screen.navigationStack
        ) { event ->
            when (event) {
                Screen2Event.GoToNext -> {}
            }
        }
    }

    @CircuitInject(RootScreen.RootGraph.Screen2::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen2: RootScreen.RootGraph.Screen2,
            navigator: Navigator
        ): Screen2Presenter
    }
}