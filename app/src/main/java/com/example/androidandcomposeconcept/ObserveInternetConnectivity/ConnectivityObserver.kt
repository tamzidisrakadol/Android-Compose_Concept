package com.example.androidandcomposeconcept.ObserveInternetConnectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    val isConnected: Flow<Boolean>
}