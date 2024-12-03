package com.yunho.circuitsample.home.screen3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen3
import com.yunho.circuitsample.home.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen3::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen3(
    screen3UiState: Screen3UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .navigationBarsPadding(),
            navigationStack = screen3UiState.navigationStack
        )
    }
}