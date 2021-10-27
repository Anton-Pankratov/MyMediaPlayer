package net.app.mymediaplayer.media.components.callback

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.SimpleExoPlayer
import net.app.mymediaplayer.media.components.playlist.PlaylistController
import net.app.mymediaplayer.media.components.playlist.SoundTrack
import net.app.mymediaplayer.media.service.MediaBrowserServiceImpl

class MediaSessionCallbackImpl(
    private val context: Context,
    private val player: SimpleExoPlayer,
    private val playlistController: PlaylistController
) : MediaSessionCompat.Callback(), MediaSessionCallback {

    private var _metadata: MediaMetadataCompat? = null
    override val metadata get() = requireNotNull(_metadata)

    override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {
        super.onPlayFromMediaId(mediaId, extras)
    }

    override fun playTrack() {
        if (player.playWhenReady) {
            context.startService(Intent(context, MediaBrowserServiceImpl::class.java))
        }
    }

    override fun updateMetadata(track: SoundTrack) {
        with(track) {
            _metadata = MediaMetadataCompat.Builder().apply {
                putBitmap(
                    MediaMetadataCompat.METADATA_KEY_ART,
                    playlistController.images[bitmapUri]
                )
                putString(MediaMetadataCompat.METADATA_KEY_TITLE, title)
                putString(MediaMetadataCompat.METADATA_KEY_ALBUM, artist)
                putString(MediaMetadataCompat.METADATA_KEY_ARTIST, artist)
                putLong(MediaMetadataCompat.METADATA_KEY_DURATION, duration)
            }.build()
        }
    }
}