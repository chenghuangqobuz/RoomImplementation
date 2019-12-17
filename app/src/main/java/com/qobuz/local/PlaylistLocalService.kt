package com.qobuz.local

import com.qobuz.local.domain_model.Playlist

interface PlaylistLocalService {

    fun savePlaylist(playlist: Playlist)

    fun deletePlaylist(playlist: Playlist)

}