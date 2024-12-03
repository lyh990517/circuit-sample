package com.yunho.circuitsample.home.nested.screen1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.RootScreen
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    RootScreen.RootGraph.Screen1.Screen1Graph.NestedScreen1::class,
    ActivityRetainedComponent::class
)
@Composable
fun NestedScreen1(
    nestedScreen1UiState: NestedScreen1UiState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("NavigationStack", fontSize = 25.sp)
        nestedScreen1UiState.navigationStack.forEach { stack ->
            Text(
                modifier = Modifier,
                text = stack.toString()
            )
        }
    }
}