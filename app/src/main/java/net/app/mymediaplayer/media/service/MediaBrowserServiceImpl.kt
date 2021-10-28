package net.app.mymediaplayer.media.service

import android.annotation.SuppressLint
import android.media.AudioManager
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import androidx.media.AudioFocusRequestCompat
import androidx.media.MediaBrowserServiceCompat
import net.app.mymediaplayer.media.player.MediaPlayer

@SuppressLint("WrongConstant")
class MediaBrowserServiceImpl(
    private val mediaPlayer: MediaPlayer
) : MediaBrowserServiceCompat(), MediaBrowserService {


    override val audioFocusRequest: AudioFocusRequestCompat by lazy {
        AudioFocusRequestCompat.Builder(AudioManager.AUDIOFOCUS_GAIN)

            .build()
    }

    override fun onCreate() {
        super.onCreate()

    }

    override fun onGetRoot(
        clientPackageName: String,
        clientUid: Int,
        rootHints: Bundle?
    ): BrowserRoot? {
        TODO("Not yet implemented")
    }

    override fun onLoadChildren(
        parentId: String,
        result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        TODO("Not yet implemented")
    }
}