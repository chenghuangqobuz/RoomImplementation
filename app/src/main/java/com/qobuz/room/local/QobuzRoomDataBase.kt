package com.qobuz.room.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qobuz.room.local.dao.*
import com.qobuz.room.local.model.entity.*


@Database(
    entities = [
        TrackEntity::class,
        ArtistEntity::class,
        AlbumEntity::class,
        PlayListEntity::class,
        PlayListTrackEntity::class
    ],
    version = 1
)
abstract class QobuzRoomDataBase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    abstract fun artistDao(): ArtistDao

    abstract fun playListDao(): PlayListDao

    abstract fun playListTrackDao(): PlayListTrackDao

    abstract fun trackDao(): TrackDao
}