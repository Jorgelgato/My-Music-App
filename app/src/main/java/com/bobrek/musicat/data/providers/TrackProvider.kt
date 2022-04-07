package com.bobrek.musicat.data.providers

import com.bobrek.musicat.domain.model.Track
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TrackProvider @Inject constructor(){
    var tracks: List<Track> = emptyList()
}