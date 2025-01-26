package com.example.androidandcomposeconcept.PractiseSet.ObserveInternetConnectivity

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidandcomposeconcept.Greeting

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