package com.yunho.circuitsample.home.screen3

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen3
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen3Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen3,
    @Assisted private val navigator: Navigator
) : Presenter<Screen3UiState> {
    @Composable
    override fun present(): Screen3UiState {
        return Screen3UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                else -> {}
            }
        }
    }

    @CircuitInject(
        Screen3::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen3,
            navigator: Navigator
        ): Screen3Presenter
    }
}