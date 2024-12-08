package com.example.androidandcomposeconcept

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidandcomposeconcept.ObserveInternetConnectivity.AndroidConnectivityObserver
import com.example.androidandcomposeconcept.ObserveInternetConnectivity.CheckNetworkState
import com.example.androidandcomposeconcept.ObserveInternetConnectivity.ConnectivityViewModel
import com.example.androidandcomposeconcept.ui.theme.AndroidAndComposeConceptTheme
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAndComposeConceptTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CheckNetworkState()
                }
            }
        }
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
    AndroidAndComposeConceptTheme {
        Greeting("Android")
    }
}