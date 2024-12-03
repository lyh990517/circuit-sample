package com.yunho.circuitsample.screen6

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen6
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen6Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen6,
    @Assisted private val navigator: Navigator
) : Presenter<Screen6UiState> {
    @Composable
    override fun present(): Screen6UiState {
        return Screen6UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                else -> {}
            }
        }
    }

    @CircuitInject(
        Screen6::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen6,
            navigator: Navigator
        ): Screen6Presenter
    }
}