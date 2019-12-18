package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.local.room.model.entity.AlbumEntity
import com.qobuz.local.room.model.relation.AlbumWithTracksRelation

@Dao
abstract class AlbumDao : BaseDao<AlbumEntity>() {

    @Transaction
    @Query("SELECT * from Album WHERE album_id = :albumId")
    abstract fun getAlbumWithTracks(albumId: String): AlbumWithTracksRelation

    @Transaction
    @Query("SELECT * from Album WHERE album_id > :albumId")
    abstract fun searchAlbumWithTracks(albumId: String): AlbumWithTracksRelation

}