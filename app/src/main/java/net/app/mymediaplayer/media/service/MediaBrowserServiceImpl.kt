package net.app.mymediaplayer.media.service

import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import androidx.media.MediaBrowserServiceCompat
import net.app.mymediaplayer.media.player.MediaPlayer

class MediaBrowserServiceImpl(
    private val mediaPlayer: MediaPlayer
    ) : MediaBrowserServiceCompat(), MediaBrowserService {

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