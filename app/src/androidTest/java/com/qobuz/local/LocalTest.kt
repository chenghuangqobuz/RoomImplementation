package com.qobuz.local

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.qobuz.local.room.QobuzRoomDataBase
import com.qobuz.local.room.dao.*
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
    private lateinit var playlistDao: PlaylistDao
    private lateinit var playlistTrackDao: PlaylistTrackDao

    private lateinit var db: QobuzRoomDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, QobuzRoomDataBase::class.java).build()
        db.clearAllTables()
        playlistDao = db.playListDao()
        artistDao = db.artistDao()
        albumDao = db.albumDao()
        trackDao = db.trackDao()
        playlistTrackDao = db.playListTrackDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        artistDao.insert(TestUtils.artist1)
        artistDao.insert(TestUtils.artist2)

        val listResults = artistDao.getAll()
        Assert.assertEquals(listOf(TestUtils.artist1, TestUtils.artist2).toString(), listResults.toString())

        albumDao.insert(TestUtils.album1)
        albumDao.insert(TestUtils.album2)

        trackDao.upsert(TestUtils.album1Track1)
        trackDao.upsert(TestUtils.album1Track2)
        trackDao.upsert(TestUtils.album2Track1)



        playlistDao.upsert(TestUtils.playList1)
        playlistDao.upsert(TestUtils.playList2)

        playlistTrackDao.upsert(listOf(
            TestUtils.playList1Album1Track1,
            TestUtils.playList1Album2Track1,
            TestUtils.playList2Album1Track2,
            TestUtils.playList2Album2Track1)
        )


        val playListWithTracks = playlistDao.getAllPlayListWithTracks()
        Log.e("PLAYLIST", playListWithTracks.toString())


        val albumWithTrack = albumDao.getAlbumWithTracks(TestUtils.album1.albumId)
        Log.e("ALBUM", albumWithTrack.toString())
    }
}