package com.qobuz.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qobuz.local.room.dao.*
import com.qobuz.local.room.model.entity.*


@Database(
    entities = [
        TrackEntity::class,
        ArtistEntity::class,
        AlbumEntity::class,
        PlaylistEntity::class,
        PlaylistTrackEntity::class
    ],
    version = 1
)
abstract class QobuzRoomDataBase : RoomDatabase() {

    abstract fun albumDao(): AlbumDao

    abstract fun artistDao(): ArtistDao

    abstract fun playListDao(): PlaylistDao

    abstract fun playListTrackDao(): PlaylistTrackDao

    abstract fun trackDao(): TrackDao
}