package com.example.androidandcomposeconcept.ObserveInternetConnectivity

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.core.content.getSystemService
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

class AndroidConnectivityObserver (private val context: Context): ConnectivityObserver{

    private val getConnectivityManager = context.getSystemService<ConnectivityManager>()

    override val isConnected: Flow<Boolean>
        get() = callbackFlow {
            val callback = object : ConnectivityManager.NetworkCallback(){
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    trySend(true)
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    trySend(false)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    trySend(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    val connected = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                    trySend(connected)
                }

            }
            getConnectivityManager?.registerDefaultNetworkCallback(callback)
            awaitClose {
                getConnectivityManager?.unregisterNetworkCallback(callback)
            }
        }

}