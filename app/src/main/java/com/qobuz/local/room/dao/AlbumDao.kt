package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.qobuz.local.room.model.entity.AlbumEntity
import com.qobuz.local.room.model.relation.AlbumWithTracksRelation

@Dao
abstract class AlbumDao : BaseDao<AlbumEntity>() {

    @Query("SELECT * from Album WHERE albumId = :albumId")
    abstract fun getAlbumWithTracks(albumId: String): AlbumWithTracksRelation

}