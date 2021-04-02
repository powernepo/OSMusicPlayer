package com.powernepo.osmusicplayer

import android.app.Notification
import android.media.MediaMetadata
import android.net.Uri
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.media.MediaBrowserServiceCompat
import androidx.media.app.NotificationCompat
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.powernepo.device_media.music.domain.model.Music
import com.powernepo.device_media.music.domain.repository.MusicRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MusicService : MediaBrowserServiceCompat() {

    companion object {
        private val TAG = MusicService::class.java.simpleName
    }

    @Inject
    lateinit var repository: MusicRepository

    private val mediaSession: MediaSessionCompat by lazy {
        MediaSessionCompat(this, TAG)
    }

    private fun extractMediaSourceFromUri(uri: Uri): MediaSource {
        return ProgressiveMediaSource.Factory(
            DefaultDataSourceFactory(
                this,
                Util.getUserAgent(this, "OSMusicPlayer")
            ), DefaultExtractorsFactory()
        ).createMediaSource(MediaItem.fromUri(uri))
    }

    private val serviceJob = SupervisorJob()
    private val ioScope = CoroutineScope(Dispatchers.IO + serviceJob)
    private val mainScope = CoroutineScope(Dispatchers.Main + serviceJob)

    override fun onCreate() {
        super.onCreate()
        mediaSession.apply {
            // Set an initial PlaybackState with ACTION_PLAY, so media buttons can start the player
            val playbackState = PlaybackStateCompat.Builder().apply {
                setActions(
                    PlaybackStateCompat.ACTION_PLAY or
                            PlaybackStateCompat.ACTION_PLAY_PAUSE or
                            PlaybackStateCompat.ACTION_SEEK_TO
                )
                setState(PlaybackStateCompat.STATE_PLAYING, 10, 1F)
            }.build()

            setPlaybackState(playbackState)
            setCallback(MediaSessionCallback())
            setSessionToken(sessionToken)
        }


        val mediaStyle = NotificationCompat.MediaStyle().setMediaSession(mediaSession.sessionToken)

        val notification = androidx.core.app.NotificationCompat.Builder(this, "music_service")
            .setStyle(mediaStyle)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()


        mediaSession.setMetadata(
            MediaMetadataCompat.Builder()
                .putString(MediaMetadata.METADATA_KEY_TITLE, "currentTrack.title")
                .putString(MediaMetadata.METADATA_KEY_ARTIST, " currentTrack.artist")
                .putLong(MediaMetadata.METADATA_KEY_DURATION, 1234L).build()
        )

    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<List<MediaBrowserCompat.MediaItem>>
    ) {
        ioScope.launch {
            val musics = repository.allMusics()
            val mediaItems = musics.map {
                it.toMediaBrowserCompat()
            }
            result.sendResult(mediaItems)
        }
        result.detach()
    }

    private fun Music.toMediaBrowserCompat(): MediaBrowserCompat.MediaItem {
        val metadataKeyValue = mapOf(
            MediaMetadataCompat.METADATA_KEY_MEDIA_ID to id,
            MediaMetadataCompat.METADATA_KEY_MEDIA_URI to data,
            MediaMetadataCompat.METADATA_KEY_TITLE to title,
        )

        val metadata = MediaMetadataCompat.Builder().apply {
            metadataKeyValue.forEach(this::putString)
        }.build()

        return metadata.run {
            MediaBrowserCompat.MediaItem(
                description,
                MediaBrowserCompat.MediaItem.FLAG_PLAYABLE
            )
        }
    }

    override fun onSearch(
        query: String,
        extras: Bundle?,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        super.onSearch(query, extras, result)
    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ) = BrowserRoot("", null)

    override fun onDestroy() {
        serviceJob.cancel()
        super.onDestroy()
    }

    inner class MediaSessionCallback : MediaSessionCompat.Callback() {
        override fun onPlay() {
            super.onPlay()
        }

        override fun onPause() {
            super.onPause()
        }

        override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {
            super.onPlayFromMediaId(mediaId, extras)
        }

        override fun onPlayFromUri(uri: Uri?, extras: Bundle?) {
            val mediaSource = extractMediaSourceFromUri(uri!!)
            mediaSource.initialTimeline
        }

        override fun onStop() {
            super.onStop()
        }
    }
}