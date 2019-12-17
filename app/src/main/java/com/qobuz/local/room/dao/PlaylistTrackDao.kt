package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.qobuz.local.room.model.entity.PlaylistTrackEntity

@Dao
abstract class PlaylistTrackDao : BaseDao<PlaylistTrackEntity>() {

    @Query("SELECT trackId FROM PlaylistTrack WHERE playlistId = :playlistId")
    abstract fun getAllTracks(playlistId: String): List<String>

    @Query("DELETE FROM PlaylistTrack WHERE playlistId = :playlistId")
    abstract fun deletePlayList(playlistId: String)

}