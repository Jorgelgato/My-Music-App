package com.bobrek.musicat.domain.model

data class Playlist(
    val collaborative: Boolean?,
    val description: String?,
    val external_urls: Any?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    val name: String,
    val owner: User,
    val primary_color: Any?,
    val public: Boolean?,
    val snapshot_id: String?,
    val tracks: Any?,
    val type: String?,
    val uri: String
)