package net.app.mymediaplayer.media.session

import android.app.PendingIntent
import android.support.v4.media.session.MediaSessionCompat

interface MediaSession {

    val activityIntent: PendingIntent

    val mediaBtnIntent: PendingIntent

    fun build(callback: MediaSessionCompat.Callback): MediaSessionCompat
}