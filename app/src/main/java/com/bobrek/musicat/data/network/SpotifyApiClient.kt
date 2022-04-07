package com.bobrek.musicat.data.network

import com.bobrek.musicat.data.models.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface SpotifyApiClient {
    @GET("me/playlists")
    suspend fun getPlaylists(): Response<ResponseModel>
}
