package com.qobuz.local

import com.qobuz.local.domain_model.Track

interface TrackLocalService {

    fun saveTrack(track: Track)

    fun deleteTrack(track: Track)

}