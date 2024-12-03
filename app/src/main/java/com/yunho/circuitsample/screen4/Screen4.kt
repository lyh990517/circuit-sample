package com.yunho.circuitsample.screen4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.yunho.circuitsample.Screen4
import com.yunho.circuitsample.Screen5
import com.yunho.circuitsample.Screen6
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen4::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen4(
    screen4UiState: Screen4UiState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        NavigationStack(
            modifier = Modifier.align(Alignment.BottomEnd),
            navigationStack = screen4UiState.navigationStack
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nested Screen in Screen4", fontSize = 10.sp)
            CircuitContent(
                screen = screen4UiState.displayedScreen,
                modifier = Modifier
                    .fillMaxSize(0.4f)
                    .background(Color.Gray),
                onNavEvent = { event -> screen4UiState.eventSink(Screen4Event.NestedNavEvent(event)) }
            )
            Button(onClick = {
                screen4UiState.eventSink(Screen4Event.ChangeScreen(Screen5()))
            }) {
                Text("screen5")
            }
            Button(onClick = {
                screen4UiState.eventSink(Screen4Event.ChangeScreen(Screen6()))
            }) {
                Text("screen6")
            }
        }
    }
}