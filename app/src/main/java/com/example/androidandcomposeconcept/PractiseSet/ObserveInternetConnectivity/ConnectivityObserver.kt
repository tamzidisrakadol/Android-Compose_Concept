package com.example.androidandcomposeconcept.PractiseSet.ObserveInternetConnectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityObserver {
    val isConnected: Flow<Boolean>
}