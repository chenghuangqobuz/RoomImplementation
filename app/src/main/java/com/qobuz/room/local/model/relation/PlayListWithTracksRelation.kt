package com.qobuz.room.local.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.qobuz.room.local.model.entity.PlayListEntity
import com.qobuz.room.local.model.entity.PlayListTrackEntity
import com.qobuz.room.local.model.entity.TrackEntity

data class PlayListWithTracksRelation(

    @Embedded
    val playlist: PlayListEntity,

    @Relation(
        parentColumn = "playlistId",
        entityColumn = "trackId",
        associateBy = Junction(PlayListTrackEntity::class)
    )
    val tracks: List<TrackEntity>
)