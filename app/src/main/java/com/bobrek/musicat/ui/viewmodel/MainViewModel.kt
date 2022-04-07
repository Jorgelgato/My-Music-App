package com.bobrek.musicat.ui.viewmodel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.ViewModel
import com.bobrek.musicat.di.SpotifyConstants
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
) : ViewModel() {

    fun getAuthenticationRequest(): AuthorizationRequest {
        return AuthorizationRequest.Builder(
            SpotifyConstants.CLIENT_ID,
            AuthorizationResponse.Type.TOKEN,
            SpotifyConstants.REDIRECT_URI
        )
            .setShowDialog(true)
            .setScopes(
                arrayOf(
                    "streaming",
                    "user-library-read",
                    "user-top-read"
                )
            )
            .build()
    }

    fun activityResult(resultCode: Int, intent: Intent?): Boolean {
        val response = AuthorizationClient.getResponse(resultCode, intent)

        when (response.type) {
            AuthorizationResponse.Type.TOKEN -> Log.d("TOKEN", response.accessToken)
            else -> Log.e("ERROR", response.error)
        }

        val accessToken: String? = response.accessToken
        if (accessToken == null) {
            Log.e("Status ", "No Access Token found")
            return false
        }
        println(accessToken)
        SpotifyConstants.TOKEN = accessToken
        return true
    }

}