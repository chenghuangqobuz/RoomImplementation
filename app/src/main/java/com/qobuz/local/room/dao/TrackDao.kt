package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.local.room.model.entity.TrackEntity
import com.qobuz.local.room.model.relation.TrackWithAlbumRelation

@Dao
abstract class TrackDao : BaseDao<TrackEntity>() {

    @Query("SELECT * FROM Track")
    abstract fun getAll() : List<TrackEntity>


    @Transaction
    @Query("SELECT * FROM Track")
    abstract fun getAllTracksWithAlbum() : List<TrackWithAlbumRelation>
}