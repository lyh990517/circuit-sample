package com.yunho.circuitsample.home.nested.screen2

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.home.nested.screen1.NestedScreen1Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class NestedScreen2Presenter @AssistedInject constructor(
    @Assisted private val screen: RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen2,
    @Assisted private val navigator: Navigator
) : Presenter<NestedScreen2UiState> {
    @Composable
    override fun present(): NestedScreen2UiState {
        return NestedScreen2UiState(
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                NestedScreen2Event.GoToNext -> {}
            }
        }
    }

    @CircuitInject(
        RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen2::class,
        ActivityRetainedComponent::class
    )
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen: RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen2,
            navigator: Navigator
        ): NestedScreen2Presenter
    }
}