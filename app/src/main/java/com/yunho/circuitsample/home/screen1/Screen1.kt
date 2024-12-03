package com.yunho.circuitsample.home.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.home.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(RootScreen.Screen1::class, ActivityRetainedComponent::class)
@Composable
fun Screen1(
    screen1UiState: Screen1UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        NavigationStack(
            modifier = Modifier.align(Alignment.BottomEnd),
            navigationStack = screen1UiState.navigationStack
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                screen1UiState.eventSink(Screen1Event.GoToNestedScreen1)
            }) {
                Text("go to nested screen1")
            }
            Button(onClick = {
                screen1UiState.eventSink(Screen1Event.GoToNestedScreen2)
            }) {
                Text("go to nested screen2")
            }
        }
    }
}