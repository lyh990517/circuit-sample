package com.yunho.circuitsample.screen6

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.onNavEvent
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.slack.circuit.runtime.screen.Screen
import com.yunho.circuitsample.Screen6
import com.yunho.circuitsample.Screen7
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
        var displayedScreen by remember { mutableStateOf<Screen>(Screen7()) }

        return Screen6UiState(
            displayedScreen = displayedScreen,
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                is Screen6Event.ChangeScreen -> displayedScreen = event.screen
                is Screen6Event.NestedNavEvent -> navigator.onNavEvent(event.navEvent)
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