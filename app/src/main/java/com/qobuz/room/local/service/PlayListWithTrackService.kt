package com.qobuz.room.local.service

import androidx.room.Transaction
import com.qobuz.room.local.dao.PlayListTrackDao
import com.qobuz.room.local.model.entity.PlayListEntity
import com.qobuz.room.local.model.entity.PlayListTrackEntity
import com.qobuz.room.local.model.relation.PlayListWithTracksRelation

class PlayListTrackService(
    private val dao: PlayListTrackDao,
    private val playListService: BaseService<PlayListEntity>,
    private val trackService: TrackService
) {

    @Transaction
    fun savePlayListWithTrack(playListWithTracksRelation: PlayListWithTracksRelation) {
        deletePlayListWithTrack(playListWithTracksRelation.playlist.playlistId)
        playListService.upsert(playListWithTracksRelation.playlist)
        playListWithTracksRelation.tracks.forEach {
            trackService.upsert(it)
            dao.upsert(
                PlayListTrackEntity(
                    playListWithTracksRelation.playlist.playlistId,
                    it.trackId
                )
            )
        }
    }


    @Transaction
    fun deletePlayListWithTrack(playListId: String) {
        val listTrack = dao.getAllTracks(playListId)
        dao.deletePlayList(playListId)
        playListService.deleteById(playListId)
        trackService.deleteAll(listTrack)
    }
}