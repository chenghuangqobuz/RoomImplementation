package com.qobuz.room.local.dao

import androidx.room.Dao
import com.qobuz.room.local.model.entity.AlbumEntity

@Dao
abstract class AlbumDao : BaseDao<AlbumEntity>()