package com.qobuz.local.service

import com.qobuz.local.room.dao.TrackDao
import com.qobuz.local.room.model.entity.TrackEntity

class TrackService(private val trackDao: TrackDao) : BaseService<TrackEntity>(trackDao) {

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