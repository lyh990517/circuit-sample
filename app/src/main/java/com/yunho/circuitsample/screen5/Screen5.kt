package com.yunho.circuitsample.screen5

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen5
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen5::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen5(
    screen5UiState: Screen5UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("im screen5", fontSize = 10.sp)
            Spacer(Modifier.weight(1f))
            NavigationStack(
                navigationStack = screen5UiState.navigationStack
            )
        }
    }
}