package com.bobrek.musicat.data.network

import com.bobrek.musicat.data.models.PlaylistModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PlaylistService @Inject constructor(
    private val api: SpotifyApiClient,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun getPlaylists(): List<PlaylistModel> {
        return withContext(dispatcher) {
            api.getPlaylists().body()?.items?.map {
                Gson().fromJson(
                    it,
                    PlaylistModel::class.java
                )
            } ?: emptyList()
        }
    }
}