package com.qobuz.local.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "PlaylistTrack", primaryKeys = ["playlist_id", "track_id"],
    foreignKeys = [
        ForeignKey(
            entity = PlaylistEntity::class,
            parentColumns = ["playlist_id"],
            childColumns = ["playlist_id"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = TrackEntity::class,
            parentColumns = ["track_id"],
            childColumns = ["track_id"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index(value = ["track_id", "track_id"], name = "index", unique = true)]
)
data class PlaylistTrackEntity(

    @ColumnInfo(name = "playlist_id")
    val playlistId: String,

    @ColumnInfo(name = "track_id")
    val trackId: String
)