package com.example.androidandcomposeconcept.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

//Example 1:
@Composable
fun MainUI(stateViewModel: StateViewModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                //stateViewModel.submitData()
            }
        ) {
            Text("DB call")
        }

        Button(
            onClick = {
                //stateViewModel.fetchData()
            }
        ) {
            Text("Api call")
        }
    }
}

/* there are 2 problem in this code
1. If we pass viewmodel into constructor,it can be issue while seeing preview,
2. It can use isolation ui test
*/

//Solution of the example 1

//remove viewmodel from the constructor
//pass lambda for event handler as parameter
@Composable
fun MainUISolution(
    dbCall: () -> Unit,
    apiCall: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                dbCall()
            }
        ) {
            Text("DB call")
        }

        Button(
            onClick = {
                apiCall()
            }
        ) {
            Text("Api call")
        }
    }
}
