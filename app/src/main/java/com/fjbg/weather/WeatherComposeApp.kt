package com.fjbg.weather

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.weather.navigation.Action
import com.fjbg.weather.navigation.Destination.AddLocation
import com.fjbg.weather.navigation.Destination.Home
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.view.addlocation.AddLocationView
import com.fjbg.weather.ui.view.main.MainView
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun WeatherComposeApp(viewModel: WeatherViewModel) {
    val navController = rememberNavController()
    val action = remember(navController) { Action(navController = navController) }

    WeatherTheme {
        NavHost(navController = navController, startDestination = Home) {
            composable(Home) {
                MainView(
                    viewModel = viewModel,
                    actionAddLocation = action.addLocation,
                )
            }
            composable(AddLocation) {
                AddLocationView(
                    viewModel = viewModel,
                    actionGoBack = action.navigateBack
                )
            }
        }
    }
}
