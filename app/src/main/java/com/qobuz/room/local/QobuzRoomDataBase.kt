package com.qobuz.room.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qobuz.room.local.model.entity.ArtistEntity
import com.qobuz.room.local.model.entity.AlbumEntity
import com.qobuz.room.local.model.entity.TrackEntity


@Database(entities = [TrackEntity::class, ArtistEntity::class, AlbumEntity::class], version = 1)
abstract class QobuzRoomDataBase : RoomDatabase() {
    //abstract fun userDao(): SongDao
}