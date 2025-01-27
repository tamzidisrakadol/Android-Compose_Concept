package com.example.utilities.logging

import android.util.Log
import com.example.utilities.BuildConfig

object AppLogger {

    private const val TAG = "App"
    fun d(message: String) {
        if (BuildConfig.DEBUG){
            Log.d(TAG, message)
        }
    }
    fun e(message: String) {
        if (BuildConfig.DEBUG){
            Log.e(TAG, message)
        }
    }
    fun i(message: String) {
        if (BuildConfig.DEBUG){
            Log.i(TAG, message)
        }
    }


}