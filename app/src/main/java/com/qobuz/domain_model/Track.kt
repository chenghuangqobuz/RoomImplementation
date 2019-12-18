package com.qobuz.domain_model

data class Track(
    val trackId: String,
    val name: String?,
    val length: Int,
    val album: Album
)