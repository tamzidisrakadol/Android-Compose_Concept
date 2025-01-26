package com.example.androidandcomposeconcept.PractiseSet.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


/* the problem in this code is  if we debug the ui we can clearly visible the recomposition in both composable.
but why the list is recomposing. it should not recompose technically. That's why the concept of stablity and Immutable comes up.
*/

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var selected by remember { mutableStateOf(false) }

    Column {
        Checkbox(
            checked = selected,
            onCheckedChange = {
                selected = it
            }
        )

        ContactList(state = ContactState(listOf("Android", "iphone", "samsung"), false))
    }
}

@Composable
fun ContactList(
    state: ContactState
) {
    Box(contentAlignment = Alignment.Center) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = state.names.toString())
        }
    }
}

//solution👇
//@stable -> if we use this annotation it will work as setter. It will not recompose the ui.
// it will skip the recomposition. we can change the value but it backfire the recomposition.
// @Immutable -> Immutable is stronger promise to the compose. the value is set for lifetime it will not change. that's why we use val keyword.

//@Stable
@Immutable
data class ContactState(
    val names: List<String>,
    val isLoading: Boolean
)