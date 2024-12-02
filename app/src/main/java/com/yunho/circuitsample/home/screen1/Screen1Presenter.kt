package com.yunho.circuitsample.home.screen1

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.CircuitScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen1Presenter @AssistedInject constructor(
    @Assisted private val screen: CircuitScreens.HomeGraph.Screen1,
    @Assisted private val navigator: Navigator
) : Presenter<Screen1UiState> {
    @Composable
    override fun present(): Screen1UiState {
        return Screen1UiState(
            navigationStack = listOf(screen.name) + screen.navigationStack
        ) { event ->
            when (event) {
                ScreenEvent.GoToNext -> {}
            }
        }
    }

    @CircuitInject(CircuitScreens.HomeGraph.Screen1::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen2: CircuitScreens.HomeGraph.Screen1,
            navigator: Navigator
        ): Screen1Presenter
    }
}