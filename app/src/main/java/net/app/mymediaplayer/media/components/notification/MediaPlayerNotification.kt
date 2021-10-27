package net.app.mymediaplayer.media.components.notification

import android.app.Notification
import android.app.PendingIntent
import net.app.mymediaplayer.utils.Playback
import androidx.core.app.NotificationCompat as CoreNotificationCompat
import androidx.media.app.NotificationCompat as MediaNotificationCompat

interface MediaPlayerNotification {

    fun getBy(playbackState: Int): Notification

    fun CoreNotificationCompat.Builder.configure(playbackState: Int): Notification

    fun makeStyle(): MediaNotificationCompat.MediaStyle

    fun Playback.buildAction(): CoreNotificationCompat.Action

    fun Playback.buildIntent(): PendingIntent
}