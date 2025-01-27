package com.example.androidandcomposeconcept.PractiseSet.ObserveInternetConnectivity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun CheckNetworkState(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val viewModel = viewModel<ConnectivityViewModel>{
        ConnectivityViewModel(
            connectivityObserver = AndroidConnectivityObserver(context = context)
        )
    }
    val isConnected = viewModel.isConnected.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Greeting(
            name = "Hello Is Internet Connected?",
        )
        Greeting(
            name = isConnected.value.toString(),
        )
    }
}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = name, fontStyle = FontStyle.Italic, fontSize = 30.sp)
    }
}