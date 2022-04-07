package com.bobrek.musicat.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrek.musicat.domain.GetFavouritesUseCase
import com.bobrek.musicat.domain.GetPlaylistsUseCase
import com.bobrek.musicat.domain.model.Playlist
import com.bobrek.musicat.domain.model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlaylistsUseCase: GetPlaylistsUseCase,
    private val getFavouritesUseCase: GetFavouritesUseCase
) : ViewModel() {

    val playlistModel = MutableLiveData<List<Playlist>>()
    val favouritesModel = MutableLiveData<List<Track>>()

    fun getPlaylists(){
        viewModelScope.launch {
            val result = getPlaylistsUseCase()
            if (!result.isNullOrEmpty()){
                playlistModel.postValue(result)
            }
        }
    }

    fun getFavourites(){
        viewModelScope.launch {
            val result = getFavouritesUseCase()
            if (!result.isNullOrEmpty()){
                favouritesModel.postValue(result)
            }
        }
    }
}