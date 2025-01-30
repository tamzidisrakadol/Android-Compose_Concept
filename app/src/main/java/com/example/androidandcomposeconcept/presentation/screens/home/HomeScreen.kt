package com.example.androidandcomposeconcept.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.androidandcomposeconcept.presentation.components.AppToolbar
import com.example.androidandcomposeconcept.ui.theme.whiteColor

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { AppToolbar()}
    ) {innerpadding->
        Column (
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center)
                .background(color = whiteColor)
                .padding(innerpadding)
        ){

        }
    }

}