package com.qobuz.room.local.model.entity

import androidx.room.Entity

@Entity(tableName = "PlayListTrackEntity", primaryKeys = ["playListId", "trackId"])
data class PlayListTrackEntity (

    val playListId : String,
    val trackId : String
)