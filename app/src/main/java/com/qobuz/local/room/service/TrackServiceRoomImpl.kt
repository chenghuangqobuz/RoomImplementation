package com.qobuz.local.room.service

import com.qobuz.local.TrackLocalService
import com.qobuz.domain_model.Track
import com.qobuz.local.room.dao.TrackDao
import com.qobuz.local.room.mapper.Mapper
import com.qobuz.local.room.model.entity.TrackEntity

class TrackServiceRoomImpl(
    private val trackDao: TrackDao,
    private val mapper: Mapper<Track, TrackEntity>

) : BaseRoomService<TrackEntity>(trackDao), TrackLocalService {

    override fun saveTrack(track: Track) {
        val trackEntity = mapper.mapTo(track)
        trackDao.upsert(trackEntity)
    }

    override fun deleteTrack(track: Track) {
        trackDao.delete(mapper.mapTo(track))
    }


    override fun delete(t: TrackEntity) {
        //vérifier si track que une relation en cours
        //vérifié si track et Album
        //vérifié si track avec PlayList
    }

    override fun deleteById(id: String) {
        //vérifier si track que une relation en cours
        //vérifié si track et Album
        //vérifié si track avec PlayList
    }


    fun deleteAll(trackIds: List<String>) {
        trackIds.forEach { deleteById(it) }
    }
}