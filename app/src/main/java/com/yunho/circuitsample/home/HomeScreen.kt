package com.yunho.circuitsample.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.yunho.circuitsample.CircuitScreens
import dagger.hilt.android.components.ActivityRetainedComponent

@CircuitInject(CircuitScreens.HomeScreen::class, ActivityRetainedComponent::class)
@Composable
fun HomeScreen(
    homeUiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "i'm home"
        )
    }
}