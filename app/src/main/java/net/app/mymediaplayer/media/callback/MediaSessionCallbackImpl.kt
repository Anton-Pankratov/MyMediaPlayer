package net.app.mymediaplayer.media.callback

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat

class MediaSessionCallbackImpl : MediaSessionCompat.Callback(), MediaSessionCallback {

    override fun onPlayFromMediaId(mediaId: String?, extras: Bundle?) {
        super.onPlayFromMediaId(mediaId, extras)
    }



    override fun playTrack() {
        TODO("Not yet implemented")
    }
}