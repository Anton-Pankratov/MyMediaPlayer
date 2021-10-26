package net.app.mymediaplayer.media.callback

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import net.app.mymediaplayer.media.playlist.PlaylistController
import net.app.mymediaplayer.media.playlist.SoundTrack
import net.app.mymediaplayer.media.service.MediaBrowserService
import net.app.mymediaplayer.media.session.MediaSession
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MediaSessionCallbackImpl(
    private val context: Context,
    private val player: SimpleExoPlayer,
    private val playlistController: PlaylistController,
    private val mediaSession: MediaSessionCompat
) : MediaSessionCompat.Callback(), MediaSessionCallback{

    private val metadata = MediaMetadataCompat.Builder()

    override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {
        super.onPlayFromMediaId(mediaId, extras)
    }

    override fun playTrack() {
        if (player.playWhenReady) {
            context.startService(Intent(context, MediaBrowserService::class.java))
        }
    }

    override fun updateMetadata(track: SoundTrack) {
        with(metadata) {
            putBitmap(MediaMetadataCompat.METADATA_KEY_ART, playlistController.images[track.bitmapUri])
            putString(MediaMetadataCompat.METADATA_KEY_TITLE, track.title)
            putString(MediaMetadataCompat.METADATA_KEY_ALBUM, track.artist)
            putString(MediaMetadataCompat.METADATA_KEY_ARTIST, track.artist)
            putLong(MediaMetadataCompat.METADATA_KEY_DURATION, track.duration)
        }
        mediaSession.setMetadata(metadata.build())
    }
}