package com.example.wealth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidandcomposeconcept.ui.theme.whiteColor
import com.example.design.components.AppToolbar

@Composable
fun WealthScreen(modifier: Modifier = Modifier,primaryButtonClicked: () -> Unit = {}) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = "Wealth Screen",
                isBackButtonVisible = true,
                primaryButtonClicked = primaryButtonClicked
            )
        }
    ){innerPadding->
        Column(
            modifier = modifier.fillMaxSize()
                .wrapContentSize()
                .background(whiteColor)
                .padding(innerPadding)
        ) {


        }
    }
}