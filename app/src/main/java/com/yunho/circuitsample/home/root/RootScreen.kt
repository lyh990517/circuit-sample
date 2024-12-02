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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.slack.circuit.foundation.NavEvent
import com.yunho.circuitsample.CircuitScreens
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(CircuitScreens.HomeGraph.RootScreen::class, ActivityRetainedComponent::class)
@Composable
fun RootScreen(
    rootUiState: RootUiState,
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableIntStateOf(1) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                NavigationBarItem(
                    selected = selected == 1,
                    onClick = {
                        rootUiState.eventSink(RootEvent.NestedNavEvent(NavEvent.GoTo(screen = CircuitScreens.HomeGraph.Screen1())))
                        selected = 1
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "")
                    }
                )
                NavigationBarItem(
                    selected = selected == 2,
                    onClick = {
                        rootUiState.eventSink(RootEvent.NestedNavEvent(NavEvent.GoTo(screen = CircuitScreens.HomeGraph.Screen2())))
                        selected = 2
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "2")
                    }
                )
            }
        }
    ) { paddingValues ->
        CircuitContent(
            screen = CircuitScreens.HomeGraph.Screen1(navigationStack = listOf()),
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            onNavEvent = { navEvent -> rootUiState.eventSink(RootEvent.NestedNavEvent(navEvent)) })
    }
}