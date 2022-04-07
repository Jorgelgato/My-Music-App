package com.bobrek.musicat.domain

import android.util.Log
import com.bobrek.musicat.di.SpotifyConstants

object SpotifyPlayer {

    fun play(uri: String){
        SpotifyConstants.mSpotifyAppRemote.playerApi.play(uri)
        SpotifyConstants.mSpotifyAppRemote.playerApi.subscribeToPlayerState()
            .setEventCallback {
                val track = it.track
                if (track != null) {
                    Log.d("Main", "${track.name} by ${track.artist}")
                }
            }
    }
}