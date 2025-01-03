package com.yunho.circuitsample.screen2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen2
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(Screen2::class, ActivityRetainedComponent::class)
@Composable
fun Screen2(
    screen2UiState: Screen2UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier.align(Alignment.BottomEnd),
            navigationStack = screen2UiState.navigationStack
        )
    }
}