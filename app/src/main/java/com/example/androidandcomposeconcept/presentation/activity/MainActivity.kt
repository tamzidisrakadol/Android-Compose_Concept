package com.example.androidandcomposeconcept.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.androidandcomposeconcept.R
import com.example.androidandcomposeconcept.presentation.screens.AppNavGraph
import com.example.androidandcomposeconcept.ui.theme.AndroidAndComposeConceptTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AndroidAndComposeConcept)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            AndroidAndComposeConceptTheme {
                AppNavGraph()
            }
        }
    }
}
