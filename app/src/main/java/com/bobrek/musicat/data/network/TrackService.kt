package com.bobrek.musicat.data.network

import com.bobrek.musicat.data.models.TrackInfo
import com.bobrek.musicat.data.models.TrackModel
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TrackService @Inject constructor(
    private val api: SpotifyApiClient,
    private val dispatcher: CoroutineDispatcher
) {
    suspend fun getFavourites(): List<TrackModel> {
        return withContext(dispatcher) {
            api.getFavourites().body()?.items?.map {
                Gson().fromJson(
                    it,
                    TrackInfo::class.java
                )
            }?.map { it.track } ?: emptyList()
        }
    }
}