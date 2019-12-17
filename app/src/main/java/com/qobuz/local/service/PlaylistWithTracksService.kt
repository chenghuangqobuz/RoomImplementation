package com.qobuz.local.service

import androidx.room.Transaction
import com.qobuz.local.room.dao.PlaylistTrackDao
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.entity.PlaylistTrackEntity
import com.qobuz.local.room.model.relation.PlaylistWithTracksRelation

class PlaylistWithTracksService(
    private val dao: PlaylistTrackDao,
    private val playlistService: BaseService<PlaylistEntity>,
    private val trackService: TrackService
) {

    @Transaction
    fun savePlaylistWithTracks(playistWithTracksRelation: PlaylistWithTracksRelation) {
        deletePlayListWithTrack(playistWithTracksRelation.playlist.playlistId)
        playlistService.upsert(playistWithTracksRelation.playlist)
        playistWithTracksRelation.tracks.forEach {
            trackService.upsert(it)
            dao.upsert(
                PlaylistTrackEntity(
                    playistWithTracksRelation.playlist.playlistId,
                    it.trackId
                )
            )
        }
    }


    @Transaction
    fun deletePlayListWithTrack(playListId: String) {
        val listTrack = dao.getAllTracks(playListId)
        dao.deletePlayList(playListId)
        playlistService.deleteById(playListId)
        trackService.deleteAll(listTrack)
    }
}