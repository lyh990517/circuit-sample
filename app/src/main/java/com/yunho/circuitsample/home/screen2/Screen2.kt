package com.yunho.circuitsample.home.screen2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.CircuitScreens
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(CircuitScreens.HomeGraph.Screen2::class, ActivityRetainedComponent::class)
@Composable
fun Screen2(
    screen2UiState: Screen2UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("NavigationStack", fontSize = 25.sp)
        screen2UiState.navigationStack.forEach { stack ->
            Text(
                modifier = Modifier,
                text = stack
            )
        }
        Button(onClick = {
            screen2UiState.eventSink(Screen2Event.GoToNext)
        }) {
            Text("go to next")
        }
    }
}