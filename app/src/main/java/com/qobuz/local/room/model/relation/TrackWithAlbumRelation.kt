package com.qobuz.local.room.model.relation

import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Relation
import com.qobuz.local.room.model.entity.AlbumEntity
import com.qobuz.local.room.model.entity.TrackEntity

@DatabaseView("SELECT * FROM TRACK")
data class TrackWithAlbumRelation(

    @Embedded
    val track: TrackEntity,

    @Relation(
        parentColumn = "album_id",
        entityColumn = "album_id"
    )
    val album: AlbumEntity
)