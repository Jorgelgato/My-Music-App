package com.bobrek.musicat.domain

import com.bobrek.musicat.data.repositories.PlaylistRepository
import javax.inject.Inject

class GetPlaylistsUseCase @Inject constructor(
    private val repository: PlaylistRepository
) {
    suspend operator fun invoke() = repository.getPlaylists()
}