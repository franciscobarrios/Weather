package com.fjbg.weather.navigation

import androidx.navigation.NavHostController

object Destination {
    const val Home = "home"
    const val LocationList = "location_list"
    const val AddLocation = "add_location"
}

class Action(navController: NavHostController) {
    val home: () -> Unit = { navController.navigate(Destination.Home) }
    val locationList: () -> Unit = { navController.navigate(Destination.LocationList) }
    val addLocation: () -> Unit = { navController.navigate(Destination.AddLocation) }
    val navigateBack: () -> Unit = { navController.popBackStack() }
}