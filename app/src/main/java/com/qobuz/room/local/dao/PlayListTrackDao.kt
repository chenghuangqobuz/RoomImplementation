package com.qobuz.room.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.qobuz.room.local.model.entity.PlayListTrackEntity

@Dao
abstract class PlayListTrackDao : BaseDao<PlayListTrackEntity>() {

    @Query("Select trackId FROM PlayListTrackEntity WHERE playlistId = :playlistId")
    abstract fun getAllTracks(playlistId: String): List<String>

    @Query("DELETE FROM PlayListTrackEntity WHERE playlistId = :playlistId")
    abstract fun deletePlayList(playlistId: String)

}