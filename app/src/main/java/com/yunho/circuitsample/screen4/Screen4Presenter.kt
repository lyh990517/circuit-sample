package com.yunho.circuitsample.screen4

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
import com.yunho.circuitsample.Screen4
import com.yunho.circuitsample.Screen5
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
        var displayedScreen by remember { mutableStateOf<Screen>(Screen5()) }

        return Screen4UiState(
            displayedScreen = displayedScreen,
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                is Screen4Event.ChangeScreen -> displayedScreen = event.screen
                is Screen4Event.NestedNavEvent -> navigator.onNavEvent(event.navEvent)
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