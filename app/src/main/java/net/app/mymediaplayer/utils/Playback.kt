package net.app.mymediaplayer.utils

import android.app.PendingIntent
import android.content.Context
import android.support.v4.media.session.PlaybackStateCompat
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.media.session.MediaButtonReceiver
import net.app.mymediaplayer.R

enum class Playback(val action: Long, @DrawableRes val icon: Int, val title: String) {
    PREVIOUS(PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS, android.R.drawable.ic_media_previous, "previous"),
    PLAY(PlaybackStateCompat.ACTION_PLAY, android.R.drawable.ic_media_play, "play"),
    PAUSE(PlaybackStateCompat.ACTION_PAUSE, android.R.drawable.ic_media_pause, "pause"),
    STOP(PlaybackStateCompat.ACTION_STOP, R.drawable.ic_stop, "stop"),
    NEXT(PlaybackStateCompat.ACTION_SKIP_TO_NEXT, android.R.drawable.ic_media_next, "next"), ;

    fun makeAction(context: Context): NotificationCompat.Action {
        return NotificationCompat.Action(
            icon, title, makeMediaButtonReceiverIntent(context)
        )
    }

    fun makeMediaButtonReceiverIntent(context: Context): PendingIntent {
        return MediaButtonReceiver.buildMediaButtonPendingIntent(context, action)
    }
}