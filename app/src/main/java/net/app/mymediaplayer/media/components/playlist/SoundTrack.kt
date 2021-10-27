package net.app.mymediaplayer.media.components.playlist

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SoundTrack(
    val title: String,
    val artist: String,
    val bitmapUri: String,
    val trackUri: String,
    val duration: Long
)