package com.yunho.circuitsample.home.nested.screen2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.home.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    RootScreen.Screen1.NestedScreen2::class,
    ActivityRetainedComponent::class
)
@Composable
fun NestedScreen2(
    nestedScreen2UiState: NestedScreen2UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .navigationBarsPadding(),
            navigationStack = nestedScreen2UiState.navigationStack
        )
    }
}