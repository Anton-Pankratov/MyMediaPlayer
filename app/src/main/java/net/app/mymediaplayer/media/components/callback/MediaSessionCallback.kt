package net.app.mymediaplayer.media.components.callback

import android.support.v4.media.MediaMetadataCompat
import net.app.mymediaplayer.media.components.playlist.SoundTrack

interface MediaSessionCallback {

    val metadata: MediaMetadataCompat?

    fun playTrack()

    fun updateMetadata(track: SoundTrack)
}