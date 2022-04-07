package com.bobrek.musicat.data.models

data class UserModel(
    val country: String?,
    val display_name: String?,
    val email: String?,
    val explicit_content: List<Boolean>?,
    val external_urls: Any?,
    val followers: FollowersModel?,
    val href: String?,
    val id: String?,
    val images: List<ImageModel>?,
    val name: String?,
    val product: String?,
    val type: String?,
    val uri: String?
)
