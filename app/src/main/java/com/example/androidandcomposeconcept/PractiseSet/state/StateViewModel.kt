package com.example.androidandcomposeconcept.PractiseSet.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlin.random.Random

class StateViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    //state Flow
    private val _color = MutableStateFlow(0xFFFFFFFF)
    val color=_color.asStateFlow()

    //we can re-Write the MutableStateFlow as below with savedStateHandle
    val _randomColor = savedStateHandle.getStateFlow("color",0xFFFFFFFF)

    private var counter = 0


    //compose state
    var composeColor by mutableLongStateOf(0xFFFFFFFF)
        private set


    fun getNewColor(){
        val color = Random.nextLong(0xFFFFFFFF)
        savedStateHandle["color"] = color
        _color.value = color // we can remove this line now because we use savedStateHandle
        composeColor = color
    }


    val timer = flow {
        while (true){
            delay(1000L)
            println("Flow is active")
            emit(counter++)
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),   //google recommended way to handle screen configuration changes
        0
    )



}


/*
compose state removes boiler plate code but there are some limitation like it did not have any operator.it did not easily deal with process death

stateFlow has many flow operator like filter,map,etc. It can easily deal with process death.

**/