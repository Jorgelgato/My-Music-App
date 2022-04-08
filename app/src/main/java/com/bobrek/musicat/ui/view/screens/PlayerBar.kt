package com.bobrek.musicat.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.bobrek.musicat.ui.view.components.NetworkImage
import com.bobrek.musicat.ui.view.components.Size
import com.bobrek.musicat.ui.viewmodel.PlayerViewModel
import com.spotify.protocol.types.ImageUri


@Composable
fun PlayerBar(playerViewModel: PlayerViewModel) {
    playerViewModel.onCreate()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10))
            .background(Color.DarkGray)
    ) {
        val player = playerViewModel.player.observeAsState().value
        if (player != null) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Box(Modifier.clip(RoundedCornerShape(20))) {
                    NetworkImage(url = playerImage(player.track.imageUri), size = Size.SMALL)
                }
                Column(
                    modifier = Modifier
                        .weight(1F)
                ) {
                    Text(
                        text = player.track.name, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = player.track.artist.name,
                        modifier = Modifier.padding(start = 16.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.Favorite,
                    contentDescription = "Liked",
                    modifier = Modifier
                        .size(40.dp)
                        .padding(horizontal = 8.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            //TODO
                        }
                )
                Icon(
                    imageVector = when (player.isPaused) {
                        true -> Icons.Default.PlayArrow
                        else -> Icons.Default.Pause
                    },
                    contentDescription = "Status",
                    Modifier
                        .size(40.dp)
                        .padding(end = 8.dp)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            when (player.isPaused) {
                                true -> playerViewModel.resume()
                                else -> playerViewModel.pause()
                            }
                        }
                )
            }

        }
    }
}

fun playerImage(uri: ImageUri): String {
    return "https://i.scdn.co/image/${uri.raw!!.toString().split(":").last()}"
}