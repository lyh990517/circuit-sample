package com.yunho.circuitsample.home.nested.screen1

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
    RootScreen.Screen1.NestedScreen1::class,
    ActivityRetainedComponent::class
)
@Composable
fun NestedScreen1(
    nestedScreen1UiState: NestedScreen1UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .navigationBarsPadding(),
            navigationStack = nestedScreen1UiState.navigationStack
        )
    }
}