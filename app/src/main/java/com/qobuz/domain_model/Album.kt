package com.qobuz.domain_model

data class Album(
    val albumId: String,
    val name: String?,
    val artist: Artist
)