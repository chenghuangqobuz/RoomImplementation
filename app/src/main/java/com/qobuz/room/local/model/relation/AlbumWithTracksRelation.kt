package com.qobuz.room.local.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.qobuz.room.local.model.entity.AlbumEntity
import com.qobuz.room.local.model.entity.TrackEntity

data class AlbumWithTracksRelation(

    @Embedded
    val album: AlbumEntity,

    @Relation(
        parentColumn = "albumId",
        entityColumn = "albumId",
        associateBy = Junction(TrackEntity::class)
    )
    val tracks: List<TrackEntity>
)