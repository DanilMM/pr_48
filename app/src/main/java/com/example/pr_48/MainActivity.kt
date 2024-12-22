package com.example.pr_48

import kotlinx.coroutines.flow.StateFlow
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr_48.ui.theme.Pr_48Theme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pr_48Theme {
                GreetingScreen()
            }
        }
    }
}

@Composable
fun GreetingScreen(viewModel: GreetingViewModel = viewModel()) {
    val greeting by viewModel.greetingText.collectAsState() // Теперь должно работать
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(greeting, Modifier.padding(innerPadding))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pr_48Theme {
        GreetingScreen(viewModel = GreetingViewModel())
    }
}