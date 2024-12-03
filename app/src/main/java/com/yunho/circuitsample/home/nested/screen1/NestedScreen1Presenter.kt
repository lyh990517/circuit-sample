package com.yunho.circuitsample.home.nested.screen1

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.RootScreen
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class NestedScreen1Presenter @AssistedInject constructor(
    @Assisted private val screen: RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen1,
    @Assisted private val navigator: Navigator
) : Presenter<NestedScreen1UiState> {
    @Composable
    override fun present(): NestedScreen1UiState {
        return NestedScreen1UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                NestedScreen1Event.GoToNestedScreen1 -> {}
                NestedScreen1Event.GoToNestedScreen2 -> {}
            }
        }
    }

    @CircuitInject(
        RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen1::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen1,
            navigator: Navigator
        ): NestedScreen1Presenter
    }
}