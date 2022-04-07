package com.bobrek.musicat.domain.model

import com.bobrek.musicat.data.models.*

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
    val uri: String?
)

fun PlaylistModel.toDomain() = Playlist(
    collaborative,
    description,
    external_urls,
    href,
    id,
    images?.map { it.toDomain() },
    name,
    owner.toDomain(),
    primary_color,
    public,
    snapshot_id,
    tracks,
    type,
    uri
)

fun ImageModel.toDomain() = Image(
    height,
    url,
    width
)

fun UserModel.toDomain() = User(
    country,
    display_name,
    email,
    explicit_content,
    external_urls,
    followers?.toDomain(),
    href,
    id,
    images?.map { it.toDomain() },
    name,
    product,
    type,
    uri
)

fun FollowersModel.toDomain() = Followers(
    href,
    total
)
