package com.yunho.circuitsample.screen3

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.Screen3
import com.yunho.circuitsample.component.NavigationStack
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(
    Screen3::class,
    ActivityRetainedComponent::class
)
@Composable
fun Screen3(
    screen3UiState: Screen3UiState,
    modifier: Modifier = Modifier
) {
    BackHandler {
        screen3UiState.eventSink(Screen3Event.PopResult("come back from screen3"))
    }

    Box(modifier = modifier.fillMaxSize()) {
        Text(modifier = Modifier.align(Alignment.Center), text = "go back!")
    }
}