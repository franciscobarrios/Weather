package com.fjbg.weather.navigation

import androidx.navigation.NavHostController

object Destination {
    const val Home = "home"
    const val Location = "location"
    const val SearchLocation = "search_location"
}

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(Destination.Home) }
    val location: () -> Unit = { navController.navigate(Destination.Location) }
    val searchLocation: () -> Unit = { navController.navigate(Destination.SearchLocation) }
    val navigateBack: () -> Unit = { navController.popBackStack() }
}