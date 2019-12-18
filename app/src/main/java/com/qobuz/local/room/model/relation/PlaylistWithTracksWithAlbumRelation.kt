package com.qobuz.local.room.model.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.entity.PlaylistTrackEntity

data class PlaylistWithTracksWithAlbumRelation(

    @Embedded
    val playlist: PlaylistEntity,

    @Relation(
        parentColumn = "playlist_id",
        entityColumn = "track_id",
        associateBy = Junction(PlaylistTrackEntity::class)
    )
    val tracks: List<TrackWithAlbumRelation>
)