package com.qobuz.local.room.service

import androidx.room.Transaction
import com.qobuz.local.PlaylistLocalService
import com.qobuz.domain_model.Playlist
import com.qobuz.local.room.dao.PlaylistTrackDao
import com.qobuz.local.room.mapper.Mapper
import com.qobuz.local.room.model.entity.PlaylistEntity
import com.qobuz.local.room.model.entity.PlaylistTrackEntity
import com.qobuz.local.room.model.relation.PlaylistWithTracksRelation

class PlaylistServiceRoomImpl(
    private val playlistTrackDao: PlaylistTrackDao,
    private val playlistService: BaseRoomService<PlaylistEntity>,
    private val trackService: TrackServiceRoomImpl,
    private val mapper: Mapper<Playlist, PlaylistWithTracksRelation>
) : PlaylistLocalService {

    @Transaction
    fun savePlaylistWithTracks(playistWithTracksRelation: PlaylistWithTracksRelation) {
        deletePlayListWithTrack(playistWithTracksRelation.playlist.playlistId)
        playlistService.upsert(playistWithTracksRelation.playlist)
        playistWithTracksRelation.tracks.forEach {
            trackService.upsert(it)
            playlistTrackDao.upsert(
                PlaylistTrackEntity(
                    playistWithTracksRelation.playlist.playlistId,
                    it.trackId
                )
            )
        }
    }


    @Transaction
    fun deletePlayListWithTrack(playListId: String) {
        val listTrack = playlistTrackDao.getAllTracks(playListId)
        playlistTrackDao.deletePlayList(playListId)
        playlistService.deleteById(playListId)
        trackService.deleteAll(listTrack)
    }

    override fun savePlaylist(playlist: Playlist) {
        val playlistWithTracksRelation = mapper.mapTo(playlist)
        savePlaylistWithTracks(playlistWithTracksRelation)
    }

    override fun deletePlaylist(playlist: Playlist) {
        deletePlayListWithTrack(playListId = playlist.playlistId)
    }
}