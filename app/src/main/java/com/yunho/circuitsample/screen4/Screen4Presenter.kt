package com.yunho.circuitsample.screen4

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen4
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen4Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen4,
    @Assisted private val navigator: Navigator
) : Presenter<Screen4UiState> {
    @Composable
    override fun present(): Screen4UiState {
        return Screen4UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                Screen4Event.GoToNext -> {}
            }
        }
    }

    @CircuitInject(
        Screen4::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: Screen4,
            navigator: Navigator
        ): Screen4Presenter
    }
}