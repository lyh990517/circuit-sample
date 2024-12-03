package com.yunho.circuitsample.home.root

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
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.Screen1
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class RootPresenter @AssistedInject constructor(
    @Assisted private val navigator: Navigator
) : Presenter<RootUiState> {
    @Composable
    override fun present(): RootUiState {
        var displayedScreen by remember { mutableStateOf<Screen>(Screen1()) }

        return RootUiState(displayedScreen = displayedScreen) { event ->
            when (event) {
                is RootEvent.NestedNavEvent -> navigator.onNavEvent(event.navEvent)
                is RootEvent.ChangeScreen -> displayedScreen = event.screen
            }
        }
    }

    @CircuitInject(RootScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            navigator: Navigator
        ): RootPresenter
    }
}