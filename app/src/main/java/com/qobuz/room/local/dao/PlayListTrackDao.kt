package com.qobuz.room.local.dao

import androidx.room.Dao
import com.qobuz.room.local.model.entity.PlayListEntity
import com.qobuz.room.local.model.entity.PlayListTrackEntity

@Dao
abstract class PlayListTrackDao : BaseDao<PlayListTrackEntity>()