package com.qobuz.room

import com.qobuz.room.local.model.entity.*

object RoomModelUtils {

    val album1Track1 =  TrackEntity("album1Track1", "album1Track1", 1, "album1")
    val album1Track2 =  TrackEntity("album1Track2", "album1Track2", 2, "album1")

    val album2Track1 =  TrackEntity("album2Track1", "album2track1", 2, "album2")


    val artist1 = ArtistEntity("artist1", "artist1")
    val artist2 = ArtistEntity("artist2", "artist2")

    val album1 = AlbumEntity("album1", "album1", "artist1")
    val album2 = AlbumEntity("album2", "album2", "artist2")


    val playList1 = PlayListEntity("playlist1", "playlist1", true)
    val playList2 = PlayListEntity("playlist2", "playlist2", true)


    val playList1Album1Track1 = PlayListTrackEntity("playlist1", "album1Track1")
    val playList1Album2Track1 = PlayListTrackEntity("playlist1", "album2Track1")


    val playList2Album1Track2 = PlayListTrackEntity("playlist2", "album1Track2")
    val playList2Album2Track1 = PlayListTrackEntity("playlist2", "album2Track1")

}