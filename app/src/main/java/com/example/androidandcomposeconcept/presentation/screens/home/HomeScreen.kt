package com.example.androidandcomposeconcept.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.design.components.AppToolbar
import com.example.design.components.BannerComponent
import com.example.androidandcomposeconcept.ui.theme.whiteColor
import com.example.androidandcomposeconcept.R

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    primaryButtonClicked: () -> Unit = {},
    bannerClicked: () -> Unit = {}
) {
    Scaffold(
        topBar = {
            AppToolbar(
                title = stringResource(R.string.add_address),
                primaryButtonClicked = primaryButtonClicked
            )
        }
    ) { innerpadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.TopStart)
                .background(color = whiteColor)
                .padding(innerpadding)
        ) {
            BannerComponent(
                title = stringResource(R.string.banner_title),
                description = stringResource(R.string.banner_desc),
                imgUrl = null,
                resourceValue = R.drawable.bitcoin,
                modifier = modifier.clickable{
                    bannerClicked()
                }
            )
        }
    }

}