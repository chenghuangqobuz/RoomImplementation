package com.qobuz.local.room.model.entity

import androidx.room.*
import androidx.room.ForeignKey.NO_ACTION

@Entity(
    tableName = "Album",
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = ["artist_id"],
            childColumns = ["artist_id"],
            onDelete = NO_ACTION
        )],
    indices = [Index(name = "index_artist_id", value = ["artist_id"])]
)
data class AlbumEntity(

    @PrimaryKey
    @ColumnInfo(name = "album_id")
    val albumId: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "artist_id")
    val artistId: String
)