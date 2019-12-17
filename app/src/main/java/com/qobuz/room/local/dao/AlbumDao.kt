package com.qobuz.room.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.qobuz.room.local.model.entity.AlbumEntity
import com.qobuz.room.local.model.relation.AlbumWithTracksRelation

@Dao
abstract class AlbumDao : BaseDao<AlbumEntity>() {

    @Query("SELECT * from Album WHERE albumId = :albumId")
    abstract fun getAlbumWithTracks(albumId: String): AlbumWithTracksRelation

}