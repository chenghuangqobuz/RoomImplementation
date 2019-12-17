package com.qobuz.local.room.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Artist")
data class ArtistEntity(

    @PrimaryKey
    @ColumnInfo(name = "artistId")
    val artistId: String,

    @ColumnInfo(name = "name")
    val name: String?
)