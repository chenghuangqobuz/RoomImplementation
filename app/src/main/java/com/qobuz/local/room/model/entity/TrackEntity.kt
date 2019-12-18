package com.qobuz.local.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Track",
    foreignKeys = [
        ForeignKey(
            entity = AlbumEntity::class,
            parentColumns = ["album_id"],
            childColumns = ["album_id"],
            onDelete = ForeignKey.NO_ACTION
        )],
    indices = [androidx.room.Index(name = "index_album_id", value = ["album_id"])]
)
data class TrackEntity(

    @PrimaryKey
    @ColumnInfo(name = "track_id")
    val trackId: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "length")
    val length: Int,

    @ColumnInfo(name = "album_id")
    val albumId: String
)