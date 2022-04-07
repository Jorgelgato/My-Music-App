package com.bobrek.musicat.ui.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bobrek.musicat.R


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
