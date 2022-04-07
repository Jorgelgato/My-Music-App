package com.bobrek.musicat.data.models

data class PlaylistModel(
    val collaborative: Boolean?,
    val description: String?,
    val external_urls: Any?,
    val href: String?,
    val id: String?,
    val images: List<ImageModel>?,
    val name: String,
    val owner: UserModel,
    val primary_color: Any?,
    val public: Boolean?,
    val snapshot_id: String?,
    val tracks: Any?,
    val type: String?,
    val uri: String?
)