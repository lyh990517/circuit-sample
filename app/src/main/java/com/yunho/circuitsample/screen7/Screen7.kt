package com.yunho.circuitsample.screen7

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen7
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen7::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen7(
    screen7UiState: Screen7UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nested Screen in Screen6", fontSize = 10.sp)
            Spacer(Modifier.weight(1f))
            NavigationStack(
                navigationStack = screen7UiState.navigationStack
            )
        }
    }
}