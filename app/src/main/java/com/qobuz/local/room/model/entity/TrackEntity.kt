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
            parentColumns = ["albumId"],
            childColumns = ["albumId"],
            onDelete = ForeignKey.NO_ACTION
        )],
    indices = [androidx.room.Index(name = "index_album_id", value = ["albumId"])]
)
data class TrackEntity(

    @PrimaryKey
    @ColumnInfo(name = "trackId")
    val trackId: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "length")
    val length: Int,

    @ColumnInfo(name = "albumId")
    val albumId: String
)