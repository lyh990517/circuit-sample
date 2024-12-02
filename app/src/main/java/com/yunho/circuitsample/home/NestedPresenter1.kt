package com.yunho.circuitsample.home

import androidx.compose.runtime.Composable
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.CircuitScreens
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class NestedPresenter1 @AssistedInject constructor(
    @Assisted private val navigator: Navigator
) : Presenter<NestedUiState1> {
    @Composable
    override fun present(): NestedUiState1 {
        return NestedUiState1 { event ->
            when (event) {
                NestedEvent1.GoToNext -> {}
            }
        }
    }

    @CircuitInject(CircuitScreens.HomeGraph.NestedScreen1::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            navigator: Navigator
        ): NestedPresenter1
    }
}