package com.bobrek.musicat.ui.view.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bobrek.musicat.domain.SpotifyPlayer
import com.bobrek.musicat.domain.model.Track
import com.bobrek.musicat.ui.view.components.DisplaySongItem

@Composable
fun FavouritesScreen(
    list: List<Track>?
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        list?.forEach {
            item {
                DisplaySongItem(
                    image = it.album?.images?.get(1)?.url.toString(),
                    title = it.name,
                    user = it.artists[0].name.toString()
                ) {
                    SpotifyPlayer.play(it.uri)
                }
            }
        }
    }
}