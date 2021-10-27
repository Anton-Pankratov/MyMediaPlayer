package net.app.mymediaplayer.media.player

import android.content.Context
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.google.android.exoplayer2.C.CONTENT_TYPE_MUSIC
import com.google.android.exoplayer2.C.USAGE_MEDIA
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.audio.AudioAttributes
import net.app.mymediaplayer.media.components.callback.MediaSessionCallback
import net.app.mymediaplayer.media.components.callback.MediaSessionCallbackImpl
import net.app.mymediaplayer.media.components.notification.MediaPlayerNotification
import net.app.mymediaplayer.media.components.session.MediaSession
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MediaPlayerImpl(private val applicationContext: Context) : MediaPlayer, KoinComponent {

    override val mediaPlayer by lazy { buildMediaPlayer() }

    override val mediaSession: MediaSession by inject()

    override val mediaSessionCallback: MediaSessionCallback by inject {
        parametersOf(mediaPlayer)
    }
    override val mediaSessionCompat: MediaSessionCompat by lazy {
        mediaSession.build(
            mediaSessionCallback as MediaSessionCallbackImpl
        )
    }

    override val mediaPlayerNotification: MediaPlayerNotification by inject {
        parametersOf()
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