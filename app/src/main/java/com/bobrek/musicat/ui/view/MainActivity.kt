package com.bobrek.musicat.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import com.bobrek.musicat.di.SpotifyConstants
import com.bobrek.musicat.ui.view.screens.MainScreen
import com.bobrek.musicat.ui.viewmodel.MainViewModel
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector.ConnectionListener
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spotifyLogin()

        setContent {
            MainScreen()
        }
    }

    private fun spotifyLogin() {
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK
                && mainViewModel.activityResult(it.resultCode, it.data)
            ) {
                loginSuccess()
                startActivity(
                    Intent(
                        this,
                        HomeActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                )
                finish()
            }
        }.launch(
            AuthorizationClient.createLoginActivityIntent(
                this,
                mainViewModel.getAuthenticationRequest()
            )
        )
    }

    private fun loginSuccess() {
        SpotifyAppRemote.connect(this, ConnectionParams.Builder(SpotifyConstants.CLIENT_ID)
            .setRedirectUri(SpotifyConstants.REDIRECT_URI)
            .showAuthView(true)
            .build(),
            object : ConnectionListener {
                override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                    SpotifyConstants.mSpotifyAppRemote = spotifyAppRemote
                }

                override fun onFailure(throwable: Throwable) {
                    Log.e("MyActivity", throwable.message, throwable)
                }
            })
    }
}
