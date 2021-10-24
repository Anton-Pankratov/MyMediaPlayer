package net.app.mymediaplayer.media.player

import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ExoPlayer

interface MediaPlayer {

    fun buildMediaPlayer(): ExoPlayer

    fun buildSessionCallback(): MediaSessionCompat.Callback

    fun buildPlaybackStates(): PlaybackStateCompat.Builder
}