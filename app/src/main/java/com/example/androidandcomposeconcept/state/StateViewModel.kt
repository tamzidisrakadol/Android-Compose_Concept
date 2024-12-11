package com.example.androidandcomposeconcept.state

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class StateViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    //state Flow
    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color=_color.asStateFlow()

    //we can re-Write the MutableStateFlow as below with savedStateHandle
    val _randomColor = savedStateHandle.getStateFlow("color",0xFFFFFFFF)

    //compose state
    var composeColor by mutableLongStateOf(0xFFFFFFFF)
        private set


    fun getNewColor(){
        val color = Random.nextLong(0xFFFFFFFF)
        savedStateHandle["color"] = color
        _color.value = color // we can remove this line now because we use savedStateHandle
        composeColor = color
    }

}


/*
compose state removes boiler plate code but there are some limitation like it did not have any operator.it did not easily deal with process death

stateFlow has many flow operator like filter,map,etc. It can easily deal with process death.

**/