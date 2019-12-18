package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.qobuz.local.room.model.entity.PlaylistTrackEntity

@Dao
abstract class PlaylistTrackDao : BaseDao<PlaylistTrackEntity>() {

    @Query("SELECT * FROM PlaylistTrack")
    abstract fun getAll(): List<PlaylistTrackEntity>

    @Query("SELECT track_id FROM PlaylistTrack WHERE playlist_id = :playlistId")
    abstract fun getAllTracks(playlistId: String): List<String>

    @Query("DELETE FROM PlaylistTrack WHERE playlist_id = :playlistId")
    abstract fun deletePlayList(playlistId: String)

}