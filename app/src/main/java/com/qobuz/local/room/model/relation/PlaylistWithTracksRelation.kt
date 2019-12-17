package com.qobuz.local.room.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.entity.PlaylistTrackEntity
import com.qobuz.local.room.model.entity.TrackEntity

data class PlaylistWithTracksRelation(

    @Embedded
    val playlist: PlaylistEntity,

    @Relation(
        parentColumn = "playlistId",
        entityColumn = "trackId",
        associateBy = Junction(PlaylistTrackEntity::class)
    )
    val tracks: List<TrackEntity>
)