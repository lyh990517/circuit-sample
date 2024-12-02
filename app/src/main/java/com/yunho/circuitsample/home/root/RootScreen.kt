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
import com.yunho.circuitsample.CircuitScreens
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(CircuitScreens.HomeGraph.RootScreen::class, ActivityRetainedComponent::class)
@Composable
fun RootScreen(
    rootUiState: RootUiState,
    modifier: Modifier = Modifier
) {
    var currentScreen by remember { mutableStateOf<Screen>(CircuitScreens.HomeGraph.Screen1()) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                NavigationBarItem(
                    selected = currentScreen is CircuitScreens.HomeGraph.Screen1,
                    onClick = {
                        currentScreen = CircuitScreens.HomeGraph.Screen1()
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "")
                    }
                )
                NavigationBarItem(
                    selected = currentScreen is CircuitScreens.HomeGraph.Screen2,
                    onClick = {
                        currentScreen = CircuitScreens.HomeGraph.Screen2()
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "2")
                    }
                )
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