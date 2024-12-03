package com.yunho.circuitsample.screen6

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.yunho.circuitsample.Screen6
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen6::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen6(
    screen6UiState: Screen6UiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text("Nested Screen in Screen6", fontSize = 10.sp)
            CircuitContent(
                screen = screen6UiState.displayedScreen,
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Red)
                    .weight(1f),
                onNavEvent = { event -> screen6UiState.eventSink(Screen6Event.NestedNavEvent(event)) }
            )
            NavigationStack(
                modifier = Modifier
                    .navigationBarsPadding(),
                navigationStack = screen6UiState.navigationStack
            )
        }
    }
}