package com.qobuz.room.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.qobuz.room.local.model.entity.PlayListEntity
import com.qobuz.room.local.model.query.PlayListTrackQuery

@Dao
abstract class PlayListDao : BaseDao<PlayListEntity>() {


    @Transaction
    @Query("SELECT * FROM PLAYLIST")
    abstract fun getAllPlayListWithTracks(): List<PlayListTrackQuery>
}