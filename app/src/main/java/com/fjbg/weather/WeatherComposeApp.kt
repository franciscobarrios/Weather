package com.fjbg.weather

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.weather.navigation.Action
import com.fjbg.weather.navigation.Destination.Home
import com.fjbg.weather.navigation.Destination.Location
import com.fjbg.weather.navigation.Destination.SearchLocation
import com.fjbg.weather.ui.theme.WeatherTheme
import com.fjbg.weather.ui.view.addlocation.LocationView
import com.fjbg.weather.ui.view.addlocation.SearchLocationView
import com.fjbg.weather.ui.view.main.MainView
import com.fjbg.weather.ui.viewmodel.WeatherViewModel

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun WeatherComposeApp(
    viewModel: WeatherViewModel
) {
    val navController = rememberNavController()
    val action = remember(navController) { Action(navController = navController) }
    val timeOfTheDay = viewModel.timeOfTheDay()

    WeatherTheme {
        NavHost(
            navController = navController,
            startDestination = Home
        ) {

            composable(Home) {
                MainView(
                    viewModel = viewModel,
                    location = action.location,
                    timeOfTheDay = timeOfTheDay
                )
            }

            composable(Location) {
                LocationView(
                    viewModel = viewModel,
                    searchLocation = action.searchLocation,
                    timeOfTheDay = timeOfTheDay
                )
            }

            composable(SearchLocation) {
                SearchLocationView(
                    viewModel = viewModel,
                    timeOfTheDay = timeOfTheDay
                )
            }
        }
    }
}
