package com.bobrek.musicat.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bobrek.musicat.ui.view.screens.FavoritesScreen
import com.bobrek.musicat.ui.view.screens.HomeScreen
import com.bobrek.musicat.ui.viewmodel.HomeViewModel
import com.bobrek.musicat.ui.viewmodel.PlayerViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    playerViewModel: PlayerViewModel
) {
    NavHost(navController = navController, startDestination = Destinations.Home.route) {
        composable(Destinations.Home.route) {
            homeViewModel.getPlaylists()
            HomeScreen(homeViewModel.playlistModel.observeAsState().value, playerViewModel)
        }
        composable(Destinations.Favorites.route) {
            homeViewModel.getFavorites()
            FavoritesScreen(homeViewModel.favoritesModel.observeAsState().value, playerViewModel)
        }
    }
}