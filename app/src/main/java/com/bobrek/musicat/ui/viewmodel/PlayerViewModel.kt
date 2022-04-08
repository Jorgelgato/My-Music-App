package com.bobrek.musicat.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bobrek.musicat.di.SpotifyConstants
import com.spotify.protocol.types.PlayerState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor() : ViewModel() {

    val player = MutableLiveData<PlayerState>()

    fun onCreate() {
        SpotifyConstants.player().subscribeToPlayerState().setEventCallback {
            player.postValue(it)
        }
    }

    fun play(uri: String) {
        SpotifyConstants.player().play(uri)
    }

    fun pause(){
        SpotifyConstants.player().pause()
    }

    fun resume(){
        SpotifyConstants.player().resume()
    }
}