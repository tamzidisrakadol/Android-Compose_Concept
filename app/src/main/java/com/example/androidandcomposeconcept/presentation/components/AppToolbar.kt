package com.example.androidandcomposeconcept.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androidandcomposeconcept.R
import com.example.androidandcomposeconcept.ui.theme.PrimaryColor

@Composable
fun AppToolbar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(PrimaryColor)
            .systemBarsPadding()
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(18.dp)
    ) {
        Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = Color.White)
        Spacer(modifier = modifier.width(18.dp))
        TextComponent(
            modifier = modifier.wrapContentSize(),
            textValue = stringResource(R.string.add_address),
        )
        Spacer(modifier = modifier.weight(1f))
        Icon(imageVector = Icons.Default.Notifications, contentDescription = "", tint = Color.White)
    }
}