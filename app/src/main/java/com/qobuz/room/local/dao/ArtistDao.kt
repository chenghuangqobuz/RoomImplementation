package com.qobuz.room.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.room.local.model.entity.ArtistEntity
import com.qobuz.room.local.model.query.PlayListTrackQuery

@Dao
abstract class ArtistDao : BaseDao<ArtistEntity>() {

    @Transaction
    @Query("SELECT * FROM Artist")
    abstract fun getAll(): List<ArtistEntity>
}