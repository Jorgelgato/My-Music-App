package com.bobrek.musicat.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobrek.musicat.domain.GetFavoritesUseCase
import com.bobrek.musicat.domain.GetPlaylistsUseCase
import com.bobrek.musicat.domain.model.Playlist
import com.bobrek.musicat.domain.model.Track
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPlaylistsUseCase: GetPlaylistsUseCase,
    private val getFavoritesUseCase: GetFavoritesUseCase
) : ViewModel() {

    val playlistModel = MutableLiveData<List<Playlist>>()
    val favoritesModel = MutableLiveData<List<Track>>()

    fun getPlaylists(){
        viewModelScope.launch {
            val result = getPlaylistsUseCase()
            if (!result.isNullOrEmpty()){
                playlistModel.postValue(result)
            }
        }
    }

    fun getFavorites(){
        viewModelScope.launch {
            val result = getFavoritesUseCase()
            if (!result.isNullOrEmpty()){
                favoritesModel.postValue(result)
            }
        }
    }
}