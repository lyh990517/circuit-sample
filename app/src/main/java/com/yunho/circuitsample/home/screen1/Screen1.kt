package com.yunho.circuitsample.home.screen1

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
import com.yunho.circuitsample.RootScreen
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(RootScreen.Screen1::class, ActivityRetainedComponent::class)
@Composable
fun Screen1(
    screen1UiState: Screen1UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("NavigationStack", fontSize = 25.sp)
        screen1UiState.navigationStack.forEach { stack ->
            Text(
                modifier = Modifier,
                text = stack.toString()
            )
        }
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