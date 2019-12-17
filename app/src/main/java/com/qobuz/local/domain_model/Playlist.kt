package com.qobuz.local.domain_model

data class Playlist(
    val playlistId: String,
    val name: String?,
    val public: Boolean,
    val tracks: List<Track>
)