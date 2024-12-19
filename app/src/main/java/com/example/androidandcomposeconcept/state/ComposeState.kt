package com.example.androidandcomposeconcept.state

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

    //collectAsState vs CollectAsStateWithLifecycle

    val timer = viewModel.timer.collectAsState()
    /* the problem in here it will start the flow until the viewmodel not get destroyed it will not check the lifecycle*/
    //when the data wants only flow use collectAsState
    //when the data wants flow with lifecycle use collectAsStateWithLifecycle

    //instead of collectAsState use collectAsStateWithLifecycle
    val counterTime = viewModel.timer.collectAsStateWithLifecycle()
    // the pros of it-> it will work with lifecycle...when the app in onPause the flow will stop...when the configuration changes it will not start from the beginning


    Text(text = counterTime.toString())
    Button(
        onClick = {
          //  navController.navigate("SecondScreen")
        }
    ) {
        Text("Navigate")
    }

}