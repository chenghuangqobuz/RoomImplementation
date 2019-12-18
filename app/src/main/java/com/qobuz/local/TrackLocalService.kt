package com.qobuz.local

import com.qobuz.domain_model.Track

interface TrackLocalService {

    fun saveTrack(track: Track)

    fun deleteTrack(track: Track)

}