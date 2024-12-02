package com.yunho.circuitsample.home

import androidx.compose.runtime.Composable
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class HomePresenter @AssistedInject constructor(
    @Assisted private val navigator: Navigator
) : Presenter<HomeUiState> {
    @Composable
    override fun present(): HomeUiState {
        return HomeUiState { event ->
            when (event) {
                HomeEvent.Go -> {}
            }
        }
    }
}