package com.yunho.circuitsample.home.nested1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slack.circuit.codegen.annotations.CircuitInject
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
                        selected = 1
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "")
                    }
                )
                NavigationBarItem(
                    selected = selected == 2,
                    onClick = {
                        selected = 2
                    },
                    icon = {
                        Icon(imageVector = Icons.Default.PlayArrow, "2")
                    }
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("NavigationStack", fontSize = 25.sp)
            Text(
                modifier = Modifier,
                text = rootUiState.name
            )
            Button(onClick = {
                rootUiState.eventSink(RootEvent.GoToNext)
            }) {
                Text("go to next")
            }
        }
    }
}