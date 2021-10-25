package net.app.mymediaplayer.media.playlist

import android.graphics.Bitmap
import com.squareup.moshi.JsonAdapter

interface PlaylistController {

    val playlist: List<SoundTrack>

    fun nextTrack(): SoundTrack

    fun previousTrack(): SoundTrack

    fun parseTracks()

    fun List<SoundTrack>.formSoundtrackImages()

    fun String.formImageFromUri(): Bitmap

    fun JsonAdapter<List<SoundTrack>>.decodePlaylist(): List<SoundTrack>?

    fun formJsonAdapter(): JsonAdapter<List<SoundTrack>>
}