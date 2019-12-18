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
class LocalTest {
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
        artistDao.insert(TestModels.artist1)
        artistDao.insert(TestModels.artist2)

        val listResults = artistDao.getAll()
        Assert.assertEquals(listOf(TestModels.artist1, TestModels.artist2).toString(), listResults.toString())

        albumDao.insert(TestModels.album1)
        albumDao.insert(TestModels.album2)

        trackDao.upsert(TestModels.album1Track1)
        trackDao.upsert(TestModels.album1Track2)
        trackDao.upsert(TestModels.album2Track1)

        val albums = albumDao.searchAlbumWithTracks(TestModels.album1.albumId)

        playlistDao.upsert(TestModels.playList1)
        playlistDao.upsert(TestModels.playList2)

        playlistTrackDao.upsert(listOf(
            TestModels.playList1Album1Track1,
            TestModels.playList1Album2Track1,
            TestModels.playList2Album1Track2,
            TestModels.playList2Album2Track1)
        )


        val playListWithTracks = playlistDao.getAllPlayListWithTracks()
        Log.e("PLAYLIST", playListWithTracks.toString())


        val albumWithTrack = albumDao.getAlbumWithTracks(TestModels.album1.albumId)
        Log.e("ALBUM", albumWithTrack.toString())
    }
}