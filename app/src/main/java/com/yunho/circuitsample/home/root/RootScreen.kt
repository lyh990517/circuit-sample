package com.yunho.circuitsample.home.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.slack.circuit.runtime.screen.Screen
import com.yunho.circuitsample.RootScreen
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(RootScreen::class, ActivityRetainedComponent::class)
@Composable
fun RootScreen(
    rootUiState: RootUiState,
    modifier: Modifier = Modifier
) {
    val screens = remember {
        listOf(
            RootScreen.Screen1(),
            RootScreen.Screen2(),
        )
    }
    var currentScreen by remember { mutableStateOf<Screen>(RootScreen.Screen1()) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = screen == currentScreen,
                        onClick = { currentScreen = screen },
                        icon = { Icon(imageVector = Icons.Default.PlayArrow, "") }
                    )
                }
            }
        }
    ) { paddingValues ->
        CircuitContent(
            screen = currentScreen,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            onNavEvent = { navEvent -> rootUiState.eventSink(RootEvent.NestedNavEvent(navEvent)) })
    }
}