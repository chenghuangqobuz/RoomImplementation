package com.qobuz.room.local.dao

import androidx.room.Dao
import com.qobuz.room.local.model.entity.TrackEntity

@Dao
abstract class TrackDao : BaseDao<TrackEntity>()