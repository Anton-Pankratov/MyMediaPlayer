package net.app.mymediaplayer.media.callback

import net.app.mymediaplayer.media.playlist.SoundTrack

interface MediaSessionCallback {

    fun playTrack()

    fun updateMetadata(track: SoundTrack)
}