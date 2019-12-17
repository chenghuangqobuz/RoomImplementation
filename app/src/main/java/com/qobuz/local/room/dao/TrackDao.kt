package com.qobuz.local.room.dao

import androidx.room.Dao
import com.qobuz.local.room.model.entity.TrackEntity

@Dao
abstract class TrackDao : BaseDao<TrackEntity>() {
}