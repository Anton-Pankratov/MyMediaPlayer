package net.app.mymediaplayer.media.playlist

interface PlaylistController {

    val playlist: List<SoundTrack>

    fun parseTracks()
}