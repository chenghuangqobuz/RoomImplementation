package com.qobuz.local.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.local.room.model.entity.ArtistEntity

@Dao
abstract class ArtistDao : BaseDao<ArtistEntity>() {

    @Transaction
    @Query("SELECT * FROM Artist")
    abstract fun getAll(): List<ArtistEntity>
}