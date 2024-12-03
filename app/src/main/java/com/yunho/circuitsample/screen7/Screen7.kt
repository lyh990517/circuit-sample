package com.yunho.circuitsample.screen7

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen7
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen7::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen7(
    screen7UiState: Screen7UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        NavigationStack(
            modifier = Modifier.align(Alignment.BottomCenter),
            navigationStack = screen7UiState.navigationStack
        )
    }
}