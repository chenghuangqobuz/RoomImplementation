package com.qobuz.domain_model

data class Playlist(
    val playlistId: String,
    val name: String?,
    val public: Boolean,
    val tracks: List<Track>
)