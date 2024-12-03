package com.yunho.circuitsample.home.nested.screen2

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

@CircuitInject(
    RootScreen.Screen1.NestedScreen2::class,
    ActivityRetainedComponent::class
)
@Composable
fun NestedScreen2(
    nestedScreen2UiState: NestedScreen2UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("NavigationStack", fontSize = 25.sp)
        nestedScreen2UiState.navigationStack.forEach { stack ->
            Text(
                modifier = Modifier,
                text = stack.toString()
            )
        }
        Button(onClick = {
            nestedScreen2UiState.eventSink(NestedScreen2Event.GoToNext)
        }) {
            Text("go to next")
        }
    }
}