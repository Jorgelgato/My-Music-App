package com.bobrek.musicat.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bobrek.musicat.R
import com.bobrek.musicat.di.SpotifyConstants
import com.bobrek.musicat.ui.viewmodel.MainViewModel
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector.ConnectionListener
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.sdk.android.auth.AuthorizationClient
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var mSpotifyAppRemote: SpotifyAppRemote
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
                    mSpotifyAppRemote = spotifyAppRemote
                }

                override fun onFailure(throwable: Throwable) {
                    Log.e("MyActivity", throwable.message, throwable)
                }
            })
    }
}


@Composable
fun MainScreen() {
    Scaffold(
        content = { Content() })
}

@Composable
fun Content() {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        TittleText(text = "Musicat")
    }
}

@Composable
fun TittleText(text: String) {
    Text(text = text, fontSize = 32.sp, fontWeight = FontWeight.Bold)
}
