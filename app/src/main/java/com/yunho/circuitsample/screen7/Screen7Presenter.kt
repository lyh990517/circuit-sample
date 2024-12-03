package com.yunho.circuitsample.screen7

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen7
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen7Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen7,
    @Assisted private val navigator: Navigator
) : Presenter<Screen7UiState> {
    @Composable
    override fun present(): Screen7UiState {
        return Screen7UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                else -> {}
            }
        }
    }

    @CircuitInject(
        Screen7::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen7,
            navigator: Navigator
        ): Screen7Presenter
    }
}