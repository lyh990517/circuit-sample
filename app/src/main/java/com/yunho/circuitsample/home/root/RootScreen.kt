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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.foundation.CircuitContent
import com.yunho.circuitsample.RootScreen
import com.yunho.circuitsample.Screen1
import com.yunho.circuitsample.Screen2
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(RootScreen::class, ActivityRetainedComponent::class)
@Composable
fun RootScreen(
    rootUiState: RootUiState,
    modifier: Modifier = Modifier
) {
    val screens = remember {
        listOf(
            Screen1(),
            Screen2(),
        )
    }

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
                        selected = screen == rootUiState.displayedScreen,
                        onClick = {
                            rootUiState.eventSink(RootEvent.ChangeScreen(screen))
                        },
                        icon = { Icon(imageVector = Icons.Default.PlayArrow, "") }
                    )
                }
            }
        }
    ) { paddingValues ->
        CircuitContent(
            screen = rootUiState.displayedScreen,
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            onNavEvent = { navEvent -> rootUiState.eventSink(RootEvent.NestedNavEvent(navEvent)) })
    }
}