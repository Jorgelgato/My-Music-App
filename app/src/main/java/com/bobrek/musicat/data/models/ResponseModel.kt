package com.bobrek.musicat.data.models

import com.google.gson.JsonElement

data class ResponseModel(
    val href: String?,
    val items: List<JsonElement>?,
    val limit: Int?,
    val next: String?,
    val offset: Int?,
    val previous: String?,
    val total: Int?
)