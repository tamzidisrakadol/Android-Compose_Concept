package com.example.androidandcomposeconcept.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun BannerComponent(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    imgUrl: String? = null
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(240.dp)
            .padding(12.dp)
            .background(Color.Green)
    ) {
        AsyncImage(
            model = imgUrl,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Column(
            modifier = modifier.fillMaxWidth(),
        ) {
            title?.let { txt ->
                TextComponent(
                    modifier = modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = txt,
                    fontSizeValue = 24.sp,
                    textColorValue = Color.Black
                )
            }
            description?.let { txt ->
                TextComponent(
                    modifier = modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = txt,
                    fontSizeValue = 9.sp,
                    textColorValue = Color.Black
                )
            }

        }
    }
}