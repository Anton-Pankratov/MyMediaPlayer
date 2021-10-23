package net.app.mymediaplayer.player.notification

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat

class MediaPlayerNotification(private val applicationContext: Context) {

    fun getBy(playbackState: Int): Notification {
        NotificationCompat.Builder(applicationContext, "channel").apply {

        }
    }
}