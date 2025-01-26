package com.example.androidandcomposeconcept.PractiseSet.state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/* What is state?
=> In Jetpack Compose, state refers to any value that can change over time and affects the UI.
It's the dynamic part of your app that makes it interactive.
When the state changes, Compose automatically re-renders the UI to reflect the new state.


Advanced State Management Techniques in Jetpack Compose:
1. ViewModel
2. DataStore
3. StateFlow and SharedFlow


what is state hoisting ?
State hoisting is a technique in Jetpack Compose where we move the state of a composable function up to its parent composable.

Benefit of state hoisting
1.Centralize State Management
2.Reduce Re-compositions
3.Improve Code Readability and Maintainability
*/


@Composable
fun StateExample(modifier: Modifier = Modifier) {

    var count by remember { mutableStateOf(0) } //In this case 0 is an state. if it change it will re-render the ui

    Button(
        onClick = { count++ }
    ) {
        Text("Click no $count")
    }

}


//State hoisting
@Composable
fun WithoutStateHoisting(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column {
        CounterButton(count, { count++ })
        CounterButton(count, { count-- })
    }
}
@Composable
fun CounterButton(count: Int, onIncrement: () -> Unit) {
    Button(onClick = onIncrement) {
        Text(text = "Count: $count")
    }
}


@Composable
fun WithStateHoisting(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }

    Column {
        CounterButton2(count, { count++ }, { count-- })
    }
}

@Composable
fun CounterButton2(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
    Button(onClick = onIncrement) {
        Text(text = "Increment")
    }
    Button(onClick = onDecrement) {
        Text(text = "Decrement")
    }
}