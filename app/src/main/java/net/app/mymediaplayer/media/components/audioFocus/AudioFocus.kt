package net.app.mymediaplayer.media.components.audioFocus

import android.media.AudioManager
import androidx.media.AudioAttributesCompat
import androidx.media.AudioFocusRequestCompat

interface AudioFocus {

    val audioAttributes: AudioAttributesCompat

    val audioFocusChangedListener: AudioManager.OnAudioFocusChangeListener

    fun build(): AudioFocusRequestCompat
}