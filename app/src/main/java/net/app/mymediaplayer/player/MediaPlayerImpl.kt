package net.app.mymediaplayer.player

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.media.session.MediaButtonReceiver
import com.google.android.exoplayer2.C.CONTENT_TYPE_MUSIC
import com.google.android.exoplayer2.C.USAGE_MEDIA
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import net.app.mymediaplayer.ui.main.MainActivity
import net.app.mymediaplayer.utils.TAG_MEDIA_PLAYER

class MediaPlayerImpl(private val applicationContext: Context) : MediaPlayer {

    val mediaPlayer by lazy { buildMediaPlayer() }
    val mediaSession by lazy { buildMediaSession() }

    private val activityIntent by lazy {
        PendingIntent.getActivity(
            applicationContext, 0,
            Intent(
                applicationContext, MainActivity::class.java
            ), 0
        )
    }

    private val mediaBtnIntent by lazy {
        PendingIntent.getBroadcast(
            applicationContext, 0,
            Intent(
                Intent.ACTION_MEDIA_BUTTON,
                null, applicationContext,
                MediaButtonReceiver::class.java
            ), 0
        )
    }

    override fun buildMediaPlayer(): ExoPlayer {
        return SimpleExoPlayer.Builder(applicationContext)
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(CONTENT_TYPE_MUSIC)
                    .setUsage(USAGE_MEDIA)
                    .build(), true
            )
            .setHandleAudioBecomingNoisy(true)
            .build()
    }

    override fun buildMediaSession(): MediaSessionCompat {
        return MediaSessionCompat(applicationContext, TAG_MEDIA_PLAYER).apply {
            setMediaButtonReceiver(null)
            setCallback(buildSessionCallback())
            setSessionActivity(activityIntent)
            setMediaButtonReceiver(mediaBtnIntent)
        }
    }

    override fun buildSessionCallback(): MediaSessionCompat.Callback {
        return object : MediaSessionCompat.Callback() {
            override fun onPlay() {
                mediaPlayer.playWhenReady = true
            }

            override fun onPause() {
                mediaPlayer.playWhenReady = false
            }

            override fun onRewind() {
                super.onRewind()
            }

            override fun onFastForward() {
                super.onFastForward()
            }
        }
    }

    override fun buildPlaybackStates(): PlaybackStateCompat.Builder {
        return PlaybackStateCompat.Builder()
            .setActions(
                PlaybackStateCompat.ACTION_PLAY
                        or PlaybackStateCompat.ACTION_STOP
                        or PlaybackStateCompat.ACTION_PAUSE
                        or PlaybackStateCompat.ACTION_PLAY_PAUSE
                        or PlaybackStateCompat.ACTION_SKIP_TO_NEXT
                        or PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS
                        or PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH
            )
    }
}