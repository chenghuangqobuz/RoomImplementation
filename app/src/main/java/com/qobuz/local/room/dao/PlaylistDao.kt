package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.relation.PlaylistWithTracksRelation
import com.qobuz.local.room.model.relation.PlaylistWithTracksWithAlbumRelation

@Dao
abstract class PlaylistDao : BaseDao<PlaylistEntity>() {

    @Transaction
    @Query("SELECT * FROM Playlist")
    abstract fun getAllPlayListWithTracks(): List<PlaylistWithTracksRelation>

    /*
    @Transaction
    @Query("SELECT * FROM Playlist")
    abstract fun getAllPlayListWithTracksWithAlbum(): List<PlaylistWithTracksWithAlbumRelation>
    */
}