package net.app.mymediaplayer.media.notification

import android.app.Notification
import android.content.Context
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.core.content.ContextCompat
import net.app.mymediaplayer.R
import net.app.mymediaplayer.utils.NOTIFICATION_CHANNEL_ID
import net.app.mymediaplayer.utils.Playback
import androidx.core.app.NotificationCompat as CoreNotificationCompat
import androidx.media.app.NotificationCompat as MediaNotificationCompat

class MediaPlayerNotificationImpl(
    private val applicationContext: Context,
    private val mediaSession: MediaSessionCompat
) : MediaPlayerNotification {

    override fun getBy(playbackState: Int): Notification {
        return CoreNotificationCompat.Builder(applicationContext, "channel")
            .configure(playbackState)
    }

    override fun CoreNotificationCompat.Builder.configure(playbackState: Int): Notification {
        return apply {
            addAction(Playback.PREVIOUS.buildAction())
            addAction(
                if (playbackState == PlaybackStateCompat.STATE_PLAYING)
                    Playback.PAUSE.buildAction() else Playback.PLAY.buildAction()
            )
            addAction(Playback.NEXT.buildAction())
            setStyle(makeStyle())
            priority = CoreNotificationCompat.PRIORITY_HIGH
            color = ContextCompat.getColor(applicationContext, R.color.purple_500)
            setSmallIcon(R.drawable.ic_audio)
            setShowWhen(false)
            setOnlyAlertOnce(true)
            setChannelId(NOTIFICATION_CHANNEL_ID)

            with(mediaSession.controller) {
                metadata.description.apply {
                    setContentTitle(title)
                    setContentText(subtitle)
                    setSubText(description)
                    setLargeIcon(iconBitmap)
                    setContentIntent(sessionActivity)
                    setDeleteIntent(Playback.STOP.buildIntent())
                    setVisibility(CoreNotificationCompat.VISIBILITY_PUBLIC)
                }
            }
        }.build()
    }

    override fun makeStyle(): MediaNotificationCompat.MediaStyle {
        return MediaNotificationCompat.MediaStyle()
            .setShowActionsInCompactView(1)
            .setShowCancelButton(true)
            .setCancelButtonIntent(Playback.STOP.buildIntent())
            .setMediaSession(mediaSession.sessionToken)
    }

    override fun Playback.buildAction() = makeAction(applicationContext)

    override fun Playback.buildIntent() = makeMediaButtonReceiverIntent(applicationContext)
}