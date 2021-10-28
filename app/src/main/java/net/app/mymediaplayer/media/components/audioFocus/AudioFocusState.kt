package net.app.mymediaplayer.media.components.audioFocus

var _currentAudioFocusState = AudioFocusState.AUDIO_NO_FOCUS_NO_DUCK
val currentAudioFocusState get() = _currentAudioFocusState

var _playOnFocusGain = false
val playOnFocusGain get() = _playOnFocusGain

enum class AudioFocusState {
    AUDIO_NO_FOCUS_NO_DUCK,
    AUDIO_NO_FOCUS_CAN_DUCK,
    AUDIO_FOCUSED,
}