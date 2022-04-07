package com.bobrek.musicat.di

import com.spotify.android.appremote.api.SpotifyAppRemote

object SpotifyConstants {
    const val CLIENT_ID = "aec02d0f18f3419ab194242d4df1baf0"
    const val REDIRECT_URI = "com.bobrek.musicat://callback"
    lateinit var TOKEN: String
    lateinit var mSpotifyAppRemote: SpotifyAppRemote
}