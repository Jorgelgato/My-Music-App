package com.bobrek.musicat.domain.model

data class User(
    val country: String?,
    val display_name: String?,
    val email: String?,
    val explicit_content: List<Boolean>?,
    val external_urls: Any?,
    val followers: Followers?,
    val href: String?,
    val id: String?,
    val images: List<Image>?,
    val name: String?,
    val product: String?,
    val type: String?,
    val uri: String?
) {

    override fun toString(): String {
        return "User(country=$country, display_name=$display_name, email=$email, explicit_content=${
            explicit_content?.joinToString(
                "\n"
            )
        }, external_urls=$external_urls, followers=$followers, href=$href, id=$id, images=${
            images?.joinToString(
                "\n"
            )
        }, product=$product, name=$name, type=$type, uri=$uri)"
    }

}