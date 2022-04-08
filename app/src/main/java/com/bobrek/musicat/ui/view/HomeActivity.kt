package com.bobrek.musicat.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bobrek.musicat.ui.theme.MusicatTheme
import com.bobrek.musicat.ui.view.components.BottomBar
import com.bobrek.musicat.ui.view.navigation.NavigationHost
import com.bobrek.musicat.ui.view.screens.PlayerBar
import com.bobrek.musicat.ui.viewmodel.HomeViewModel
import com.bobrek.musicat.ui.viewmodel.PlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    private val playerViewModel: PlayerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicatTheme {
                HomeView(homeViewModel, playerViewModel)
            }
        }
    }
}

@Composable
fun HomeView(homeViewModel: HomeViewModel, playerViewModel: PlayerViewModel) {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(navHostController = navController)
    }) {
        Box(modifier = Modifier.padding(it)) {
            NavigationHost(navController, homeViewModel, playerViewModel)
            Box(
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(4.dp)
            ) {
                PlayerBar(playerViewModel)
            }
        }
    }
}