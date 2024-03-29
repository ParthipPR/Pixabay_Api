package com.Parthip.pixabay.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.Parthip.pixabay.ui.theme.PixabayTheme
import com.Parthip.pixabay.utils.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixabayTheme {
                SetBarColor(color = MaterialTheme.colorScheme.inverseOnSurface)
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.rout
                    ){
                        composable(Screen.Home.rout){
                            HomeScreen(navController)
                        }
                        composable(Screen.Details.rout + "/{imageId}",
                            arguments = listOf(
                                navArgument("imageId") { type = NavType.IntType }
                            )
                            ){BackStackEntry ->
        //                    DetailsScreen(BackStackEntry)
                        }
                    }

                }

            }
        }
    }
    @Composable
    private fun SetBarColor(color: Color) {
        val systemUiController = rememberSystemUiController()
        LaunchedEffect(key1 = color) {
            systemUiController.setSystemBarsColor(color)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PixabayTheme {

    }
}