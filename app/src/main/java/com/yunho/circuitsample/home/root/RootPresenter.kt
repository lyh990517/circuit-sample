package com.yunho.circuitsample.home.root

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.NavEvent
import com.slack.circuit.foundation.onNavEvent
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.CircuitScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class RootPresenter @AssistedInject constructor(
    @Assisted private val screen: CircuitScreens.HomeGraph.RootScreen,
    @Assisted private val navigator: Navigator
) : Presenter<RootUiState> {
    @Composable
    override fun present(): RootUiState {
        return RootUiState(screen.name) { event ->
            when (event) {
                is RootEvent.NestedNavEvent -> navigator.onNavEvent(event.navEvent)
            }
        }
    }

    @CircuitInject(CircuitScreens.HomeGraph.RootScreen::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: CircuitScreens.HomeGraph.RootScreen,
            navigator: Navigator
        ): RootPresenter
    }
}