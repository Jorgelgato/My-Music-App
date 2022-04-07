package com.bobrek.musicat.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.bobrek.musicat.ui.theme.MusicatTheme
import com.bobrek.musicat.ui.viewmodel.HomeViewModel
import com.bobrek.musicat.ui.view.screens.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicatTheme {
                Playlists(homeViewModel)
            }
        }
    }
}

@Composable
fun Playlists(homeViewModel: HomeViewModel) {
    Scaffold {
        homeViewModel.getPlaylists()
        HomeScreen(homeViewModel.playlistModel.observeAsState().value)
    }
}