package com.qobuz.local.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "PlaylistTrack", primaryKeys = ["playlistId", "trackId"],
    foreignKeys = [
        ForeignKey(
            entity = PlaylistEntity::class,
            parentColumns = ["playlistId"],
            childColumns = ["playlistId"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = TrackEntity::class,
            parentColumns = ["trackId"],
            childColumns = ["trackId"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [Index(value = ["playlistId", "trackId"], name = "index", unique = true)]
)
data class PlaylistTrackEntity(

    @ColumnInfo(name = "playlistId")
    val playlistId: String,

    @ColumnInfo(name = "trackId")
    val trackId: String
)