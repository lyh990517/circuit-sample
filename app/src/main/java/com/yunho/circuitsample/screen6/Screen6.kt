package com.yunho.circuitsample.screen6

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen6
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen6::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen6(
    screen6UiState: Screen6UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .navigationBarsPadding(),
            navigationStack = screen6UiState.navigationStack
        )
    }
}