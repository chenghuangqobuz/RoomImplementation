package com.qobuz.room

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.qobuz.room.local.QobuzRoomDataBase
import com.qobuz.room.local.dao.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SimpleEntityReadWriteTest {
    private lateinit var artistDao: ArtistDao
    private lateinit var albumDao: AlbumDao
    private lateinit var trackDao: TrackDao
    private lateinit var playListDao: PlayListDao
    private lateinit var playListTrackDao: PlayListTrackDao

    private lateinit var db: QobuzRoomDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, QobuzRoomDataBase::class.java).build()
        playListDao = db.playListDao()
        artistDao = db.artistDao()
        albumDao = db.albumDao()
        trackDao = db.trackDao()
        playListTrackDao = db.playListTrackDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        artistDao.insert(RoomModelUtils.artist1)
        artistDao.insert(RoomModelUtils.artist2)

        val listResults = artistDao.getAll()
        Assert.assertEquals(listOf(RoomModelUtils.artist1, RoomModelUtils.artist2).toString(), listResults.toString())

        albumDao.insert(RoomModelUtils.album1)
        albumDao.insert(RoomModelUtils.album2)

        trackDao.upsert(RoomModelUtils.album1Track1)
        trackDao.upsert(RoomModelUtils.album1Track2)
        trackDao.upsert(RoomModelUtils.album2Track1)

        playListDao.upsert(RoomModelUtils.playList1)
        playListDao.upsert(RoomModelUtils.playList2)

        playListTrackDao.upsert(listOf(
            RoomModelUtils.playList1Album1Track1,
            RoomModelUtils.playList1Album2Track1,
            RoomModelUtils.playList2Album1Track2,
            RoomModelUtils.playList2Album2Track1)
        )


        val playListWithTracks = playListDao.getAllPlayListWithTracks()
        Log.e("PLAYLIST", playListWithTracks.toString())


        val albumWithTrack = albumDao.getAlbumWithTracks(RoomModelUtils.album1.albumId)
        Log.e("ALBUM", albumWithTrack.toString())
    }
}