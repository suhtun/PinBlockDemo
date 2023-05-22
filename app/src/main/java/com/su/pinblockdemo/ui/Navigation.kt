package com.su.pinblockdemo.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.su.pinblockdemo.ui.pinblock.PinBlockScreen
import com.su.pinblockdemo.ui.Destinations.HOME_ROUTE

object Destinations {
    const val HOME_ROUTE = "pinblock"
}

@Composable
fun PinBlockAppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
    ) {
        composable(HOME_ROUTE) {
            PinBlockScreen()
        }
    }
}