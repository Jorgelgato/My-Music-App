package com.bobrek.musicat.data.repositories

import com.bobrek.musicat.data.network.TrackService
import com.bobrek.musicat.data.providers.TrackProvider
import com.bobrek.musicat.domain.model.Track
import com.bobrek.musicat.domain.model.toDomain
import javax.inject.Inject

class TrackRepository @Inject constructor(
    private val api: TrackService,
    private val trackProvider: TrackProvider
) {
    suspend fun getFavourites(): List<Track> {
        val response = api.getFavourites().map { it.toDomain() }
        trackProvider.tracks = response
        return response
    }
}