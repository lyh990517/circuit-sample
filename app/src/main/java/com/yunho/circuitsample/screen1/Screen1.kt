package com.yunho.circuitsample.screen1

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
import com.yunho.circuitsample.Screen1
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(Screen1::class, ActivityRetainedComponent::class)
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
                screen1UiState.eventSink(Screen1Event.GoToScreen3)
            }) {
                Text("go to screen3")
            }
            Button(onClick = {
                screen1UiState.eventSink(Screen1Event.GoToScreen4)
            }) {
                Text("go to screen4")
            }
        }
    }
}