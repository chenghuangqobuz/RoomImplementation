package com.qobuz.local.room.service

import androidx.room.Transaction
import com.qobuz.local.PlaylistLocalService
import com.qobuz.local.domain_model.Playlist
import com.qobuz.local.room.dao.PlaylistTrackDao
import com.qobuz.local.room.mapper.Mapper
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.entity.PlaylistTrackEntity
import com.qobuz.local.room.model.relation.PlaylistWithTracksRelation

class PlaylistServiceRoomImpl(
    private val dao: PlaylistTrackDao,
    private val playlistService: BaseRoomService<PlaylistEntity>,
    private val trackServiceRoomImpl: TrackServiceRoomImpl,
    private val mapper: Mapper<Playlist, PlaylistWithTracksRelation>
) : PlaylistLocalService {

    @Transaction
    fun savePlaylistWithTracks(playistWithTracksRelation: PlaylistWithTracksRelation) {
        deletePlayListWithTrack(playistWithTracksRelation.playlist.playlistId)
        playlistService.upsert(playistWithTracksRelation.playlist)
        playistWithTracksRelation.tracks.forEach {
            trackServiceRoomImpl.upsert(it)
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
        trackServiceRoomImpl.deleteAll(listTrack)
    }

    override fun savePlaylist(playlist: Playlist) {
        val playlistWithTracksRelation = mapper.mapTo(playlist)
        savePlaylistWithTracks(playlistWithTracksRelation)
    }

    override fun deletePlaylist(playlist: Playlist) {
        deletePlayListWithTrack(playListId = playlist.playlistId)
    }
}