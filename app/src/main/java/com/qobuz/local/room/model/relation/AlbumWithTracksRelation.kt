package com.qobuz.local.room.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.qobuz.local.room.model.entity.AlbumEntity
import com.qobuz.local.room.model.entity.TrackEntity

data class AlbumWithTracksRelation(

    @Embedded
    val album: AlbumEntity,

    @Relation(
        parentColumn = "album_id",
        entityColumn = "album_id",
        associateBy = Junction(TrackEntity::class)
    )
    val tracks: List<TrackEntity>
)