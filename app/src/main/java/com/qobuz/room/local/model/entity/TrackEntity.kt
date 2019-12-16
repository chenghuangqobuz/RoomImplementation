package com.qobuz.room.local.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Track")
data class TrackEntity(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "length")
    val length: Int,

    @ColumnInfo(name = "albumId")
    val albumId: String
)