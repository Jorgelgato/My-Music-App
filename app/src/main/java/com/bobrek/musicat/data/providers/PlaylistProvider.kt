package com.bobrek.musicat.data.providers

import com.bobrek.musicat.domain.model.Playlist
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaylistProvider @Inject constructor(){
    var playlists: List<Playlist> = emptyList()
}