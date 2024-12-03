package com.yunho.circuitsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.backstack.NavDecoration
import com.slack.circuit.backstack.rememberSaveableBackStack
import com.slack.circuit.foundation.Circuit
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.NavigableCircuitContent
import com.slack.circuit.foundation.rememberCircuitNavigator
import com.yunho.circuitsample.ui.theme.CircuitSampleTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.collections.immutable.ImmutableList
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var circuit: Circuit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CircuitSampleTheme {
                val backStack =
                    rememberSaveableBackStack(root = RootScreen())
                val navigator = rememberCircuitNavigator(backStack)

                CircuitCompositionLocals(circuit) {
                    NavigableCircuitContent(
                        decoration = CustomDecoration,
                        navigator = navigator,
                        backStack = backStack
                    )
                }
            }
        }
    }
}

object CustomDecoration : NavDecoration {
    @Composable
    override fun <T> DecoratedContent(
        args: ImmutableList<T>,
        backStackDepth: Int,
        modifier: Modifier,
        content: @Composable (T) -> Unit
    ) {
        AnimatedContent(
            targetState = args,
            modifier = modifier,
            transitionSpec = { fadeIn() togetherWith fadeOut() },
            label = "",
        ) { arguments ->
            content(arguments.first())
        }
    }
}