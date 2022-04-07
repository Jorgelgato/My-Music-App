package com.bobrek.musicat.domain.model

import com.bobrek.musicat.data.models.*

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

fun TrackModel.toDomain() = Track(
    album?.toDomain(),
    artists.map { it.toDomain() },
    available_markets,
    disk_number,
    duration_ms,
    explicit,
    external_ids,
    href,
    id,
    is_local,
    name,
    popularity,
    preview_url,
    track_number,
    type,
    uri,
)

fun AlbumModel.toDomain() = Album(
    album_type,
    artists?.map { it.toDomain() },
    available_markets,
    external_urls,
    href,
    id,
    images?.map { it.toDomain() },
    name,
    release_date,
    release_date_precision,
    total_tracks,
    type,
    uri
)