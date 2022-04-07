package com.bobrek.musicat.domain

import com.bobrek.musicat.data.repositories.TrackRepository
import javax.inject.Inject

class GetFavouritesUseCase @Inject constructor(
    private val repository: TrackRepository
) {
    suspend operator fun invoke() = repository.getFavourites()
}