package com.example.design.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidandcomposeconcept.ui.theme.PrimaryColor
import com.example.design.R

@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title : String,
    isBackButtonVisible: Boolean = false,
    primaryButtonClicked : () -> Unit = {}
) {
    Row(
        modifier = modifier
            .background(PrimaryColor)
            .systemBarsPadding()
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 18.dp, end = 18.dp, top = 8.dp)
    ) {
        Icon(
            imageVector =if (!isBackButtonVisible) Icons.Default.Person else Icons.Default.ArrowBack,
            contentDescription = "",
            tint = Color.White,
            modifier = modifier.size(28.dp)
                .clickable{
                    primaryButtonClicked()
                }
        )
        Spacer(modifier = modifier.width(18.dp))
        TextComponent(
            modifier = modifier.wrapContentSize(),
            textValue = title,
            fontSizeValue = 20.sp
        )
        Spacer(modifier = modifier.weight(1f))

        if (!isBackButtonVisible){
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "",
                tint = Color.White,
                modifier = modifier.size(28.dp))
        }
    }
}