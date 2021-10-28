package net.app.mymediaplayer.media.service

import android.media.AudioFocusRequest
import androidx.media.AudioFocusRequestCompat

interface MediaBrowserService {

    val audioFocusRequest: AudioFocusRequestCompat

}