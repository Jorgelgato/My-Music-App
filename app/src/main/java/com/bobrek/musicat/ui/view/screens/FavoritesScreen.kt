package com.bobrek.musicat.ui.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.bobrek.musicat.domain.model.Track
import com.bobrek.musicat.ui.view.components.DisplaySongItem
import com.bobrek.musicat.ui.viewmodel.PlayerViewModel

@Composable
fun FavoritesScreen(
    list: List<Track>?,
    playerViewModel: PlayerViewModel
) {
    val tracks = remember { mutableStateListOf<Track>() }
    list?.let { tracks.addAll(it) }
    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        itemsIndexed(tracks) { _, item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable(onClick = { playerViewModel.play(item.uri) })
            ) {
                DisplaySongItem(
                    item
                ) {
                    tracks.remove(item)
                    playerViewModel.remove(item.uri)
                }
            }
        }
    }
}