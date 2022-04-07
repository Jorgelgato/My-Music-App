package com.bobrek.musicat.data.repositories

import com.bobrek.musicat.data.network.PlaylistService
import com.bobrek.musicat.data.providers.PlaylistProvider
import com.bobrek.musicat.domain.model.Playlist
import com.bobrek.musicat.domain.model.toDomain
import javax.inject.Inject

class PlaylistRepository @Inject constructor(
    private val api: PlaylistService,
    private val playlistProvider: PlaylistProvider
) {
    suspend fun getPlaylists(): List<Playlist> {
        val response = api.getPlaylists().map { it.toDomain() }
        playlistProvider.playlists = response
        return response
    }
}