package com.yunho.circuitsample.screen1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.rememberAnsweringNavigator
import com.slack.circuit.runtime.Navigator
import com.slack.circuit.runtime.presenter.Presenter
import com.yunho.circuitsample.Screen1
import com.yunho.circuitsample.Screen3
import com.yunho.circuitsample.Screen4
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.components.ActivityRetainedComponent

class Screen1Presenter @AssistedInject constructor(
    @Assisted private val screen: Screen1,
    @Assisted private val navigator: Navigator
) : Presenter<Screen1UiState> {
    @Composable
    override fun present(): Screen1UiState {
        var data by remember { mutableStateOf("") }
        val customNavigator = rememberAnsweringNavigator<Screen3.Result>(navigator) { result ->
            data = result.data
        }

        return Screen1UiState(
            data = data,
            navigationStack = navigator.peekBackStack()
        ) { event ->
            when (event) {
                Screen1Event.GoToScreen3 -> {
                    customNavigator.goTo(Screen3())
                }

                Screen1Event.GoToScreen4 -> {
                    navigator.goTo(Screen4())
                }
            }
        }
    }

    @CircuitInject(Screen1::class, ActivityRetainedComponent::class)
    @AssistedFactory
    fun interface Factory {
        fun create(
            screen2: Screen1,
            navigator: Navigator
        ): Screen1Presenter
    }
}