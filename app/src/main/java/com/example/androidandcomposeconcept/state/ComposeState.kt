package com.example.androidandcomposeconcept.state

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ComposeState(modifier: Modifier = Modifier) {

    val viewModel = viewModel<StateViewModel>()
    val composeColor = viewModel.composeColor
    val flowColor by viewModel.color.collectAsState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(flowColor))
        .clickable{
            viewModel.getNewColor()
        },
        contentAlignment = Alignment.Center
    ) {

        Text("Click to get new color")

    }

}