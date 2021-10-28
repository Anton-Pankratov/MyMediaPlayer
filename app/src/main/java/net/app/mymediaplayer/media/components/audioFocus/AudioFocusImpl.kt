package net.app.mymediaplayer.media.components.audioFocus

import android.media.AudioManager
import androidx.media.AudioAttributesCompat
import androidx.media.AudioFocusRequestCompat
import androidx.media.AudioManagerCompat
import net.app.mymediaplayer.media.player.MediaPlayer

class AudioFocusImpl(private val player: MediaPlayer) : AudioFocus {

    override val audioAttributes: AudioAttributesCompat by lazy {
        AudioAttributesCompat.Builder()
            .setUsage(AudioAttributesCompat.USAGE_MEDIA)
            .setContentType(AudioAttributesCompat.CONTENT_TYPE_MUSIC)
            .build()
    }

    override val audioFocusChangedListener =
        AudioManager.OnAudioFocusChangeListener { focusChange ->
            with(player) {
                _currentAudioFocusState = when (focusChange) {
                    AudioManager.AUDIOFOCUS_GAIN -> AudioFocusState.AUDIO_FOCUSED
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK ->
                        AudioFocusState.AUDIO_NO_FOCUS_CAN_DUCK
                    AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                        _playOnFocusGain = exoPlayer != null && exoPlayer?.playWhenReady!!
                        AudioFocusState.AUDIO_NO_FOCUS_NO_DUCK
                    }
                    AudioManager.AUDIOFOCUS_LOSS -> AudioFocusState.AUDIO_NO_FOCUS_NO_DUCK
                    else -> AudioFocusState.AUDIO_NO_FOCUS_NO_DUCK
                }

                if (exoPlayer != null) configurePlayerState()
            }

        }

    override fun build(): AudioFocusRequestCompat {
        return AudioFocusRequestCompat.Builder(AudioManagerCompat.AUDIOFOCUS_GAIN)
            .setOnAudioFocusChangeListener(audioFocusChangedListener)
            .setWillPauseWhenDucked(true)
            .setAudioAttributes(audioAttributes)
            .build()
    }
}