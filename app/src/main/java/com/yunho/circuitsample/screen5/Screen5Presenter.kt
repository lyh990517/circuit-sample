package com.yunho.circuitsample.screen5

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen5
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen5Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen5,
    @Assisted private val navigator: Navigator
) : Presenter<Screen5UiState> {
    @Composable
    override fun present(): Screen5UiState {
        return Screen5UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                else -> {}
            }
        }
    }

    @CircuitInject(
        Screen5::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen5,
            navigator: Navigator
        ): Screen5Presenter
    }
}