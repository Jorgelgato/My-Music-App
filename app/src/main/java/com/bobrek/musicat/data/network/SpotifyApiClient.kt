package com.bobrek.musicat.data.network

import com.bobrek.musicat.data.models.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SpotifyApiClient {
    @GET("me/playlists")
    suspend fun getPlaylists(): Response<ResponseModel>

    @GET("me/tracks?")
    suspend fun getFavorites(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ResponseModel>

}
