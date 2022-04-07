package com.bobrek.musicat.ui.view.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home: Destinations("home", "Inicio", Icons.Filled.Home)
    object Favourites: Destinations("favourites", "Favoritos", Icons.Filled.Favorite)
}