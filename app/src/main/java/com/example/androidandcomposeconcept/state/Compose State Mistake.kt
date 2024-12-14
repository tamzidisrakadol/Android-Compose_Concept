package com.example.androidandcomposeconcept.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

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

//Example 2:

@Composable
fun SecondUI(modifier: Modifier = Modifier) {
    val scope = rememberCoroutineScope()

    Button(
        onClick = {
            scope.launch {
                //we have to use scope because the submit data is a suspend function
                //viewModel.submitData()
            }

            //solution -> use viewModelScope in viewModel class and use the function without suspend
            //viewModel.submitData
        }
    ) {
        Text("Click the button")
    }
}

/* there are 1 problem in this code
1. Very often using this scope coroutine can be cause an issue.
 This scope is an UI scope, which means when configuration changes it will cancel the coroutine.
 To avoid this we can use viewModelScope and use the function without suspend.

*/

@Composable
fun ThirdUI(checkLoggedIn: Boolean) {

    //Mistake 👇
    if (checkLoggedIn){
        //navController.navigate("MainScreen")
    }

    //Solution 👇
    LaunchedEffect(key1 = checkLoggedIn) {
        if (checkLoggedIn){
            //navController.navigate("MainScreen")
        }
    }


    Column {
        Button(
            onClick = {}
        ) {
            Text("Google Sign in")
        }
    }
}
/* there are 1 problem in this code
1. if there is non ui code try to use side-effect like LaunchedEffect. Because without it can re-compose n number of times
On some other hand it can lead to wierd bug.
*/


