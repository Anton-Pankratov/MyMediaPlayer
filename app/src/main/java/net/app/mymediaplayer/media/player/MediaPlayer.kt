package net.app.mymediaplayer.media.player

import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import net.app.mymediaplayer.media.components.callback.MediaSessionCallback
import net.app.mymediaplayer.media.components.notification.MediaPlayerNotification
import net.app.mymediaplayer.media.components.session.MediaSession

interface MediaPlayer {

    val mediaPlayer: ExoPlayer

    val mediaSession: MediaSession

    val mediaSessionCallback: MediaSessionCallback

    val mediaSessionCompat: MediaSessionCompat

    val mediaPlayerNotification: MediaPlayerNotification

    fun buildMediaPlayer(): ExoPlayer

    fun buildPlaybackStates(): PlaybackStateCompat.Builder
}