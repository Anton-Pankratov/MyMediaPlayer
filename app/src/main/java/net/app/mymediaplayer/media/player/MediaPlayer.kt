package net.app.mymediaplayer.media.player

import android.content.BroadcastReceiver
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import net.app.mymediaplayer.media.components.audioFocus.AudioFocus
import net.app.mymediaplayer.media.components.callback.MediaSessionCallback
import net.app.mymediaplayer.media.components.notification.MediaPlayerNotification
import net.app.mymediaplayer.media.components.session.MediaSession

interface MediaPlayer {

    val exoPlayer: ExoPlayer?

    val mediaSession: MediaSession

    val audioFocus: AudioFocus

    val mediaSessionCallback: MediaSessionCallback

    val mediaSessionCompat: MediaSessionCompat

    val mediaPlayerNotification: MediaPlayerNotification

    val becomingNoiseReceiver: BroadcastReceiver

    fun configurePlayerState()

    fun setPlayerOnPause()

    fun buildMediaPlayer(): ExoPlayer

    fun buildPlaybackStates(): PlaybackStateCompat.Builder
}