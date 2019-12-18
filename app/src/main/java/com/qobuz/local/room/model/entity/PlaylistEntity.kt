package com.qobuz.local.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Playlist")
data class PlaylistEntity(

    @PrimaryKey
    @ColumnInfo(name = "playlist_id")
    val playlistId: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "is_public")
    val publicPlaylist: Boolean
)