package com.example.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.androidandcomposeconcept.ui.theme.PrimaryColor
import kotlin.let

@Composable
fun BannerComponent(
    modifier: Modifier = Modifier,
    title: String? = null,
    description: String? = null,
    imgUrl: String? = null,
    resourceValue: Int? = null
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            //.height(240.dp)
            .wrapContentHeight()
            .padding(12.dp)
            .clip(
                shape = RoundedCornerShape(12.dp)
            )
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(PrimaryColor, Color.Black)
                )
            )
    ) {

        imgUrl?.let {
            AsyncImage(
                model = it,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
        resourceValue?.let {
            ImageComponent(
                modifier = modifier
                    .size(120.dp)
                    .align(Alignment.CenterEnd),
                resourceValue = it
            )
        }


        Column(
            modifier = modifier.fillMaxWidth().wrapContentHeight(),
        ) {
            title?.let { txt ->
                TextComponent(
                    modifier = modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = txt,
                    fontSizeValue = 24.sp,
                    textColorValue = Color.White
                )
            }
            description?.let { txt ->
                TextComponent(
                    modifier = modifier
                        .wrapContentSize()
                        .padding(8.dp),
                    textValue = txt,
                    fontSizeValue = 9.sp,
                    textColorValue = Color.White
                )
            }

        }
    }
}