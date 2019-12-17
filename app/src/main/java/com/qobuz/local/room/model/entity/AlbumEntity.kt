package com.qobuz.local.room.model.entity

import androidx.room.*
import androidx.room.ForeignKey.NO_ACTION

@Entity(
    tableName = "Album",
    foreignKeys = [
        ForeignKey(
            entity = ArtistEntity::class,
            parentColumns = ["artistId"],
            childColumns = ["artistId"],
            onDelete = NO_ACTION
        )],
    indices = [Index(name = "index_artist_id", value = ["artistId"])]
)
data class AlbumEntity(

    @PrimaryKey
    @ColumnInfo(name = "albumId")
    val albumId: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "artistId")
    val artistId: String
)