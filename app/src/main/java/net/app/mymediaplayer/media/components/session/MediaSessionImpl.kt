package net.app.mymediaplayer.media.components.session

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.media.session.MediaSessionCompat
import androidx.media.session.MediaButtonReceiver
import net.app.mymediaplayer.ui.main.MainActivity
import net.app.mymediaplayer.utils.TAG_MEDIA_PLAYER

class MediaSessionImpl(private val context: Context): MediaSession {

    override val activityIntent: PendingIntent by lazy {
        PendingIntent.getActivity(
            context, 0,
            Intent(
                context, MainActivity::class.java
            ), 0
        )
    }

    override val mediaBtnIntent: PendingIntent by lazy {
        PendingIntent.getBroadcast(
            context, 0,
            Intent(
                Intent.ACTION_MEDIA_BUTTON,
                null, context,
                MediaButtonReceiver::class.java
            ), 0
        )
    }

    override fun build(callback: MediaSessionCompat.Callback): MediaSessionCompat {
        return MediaSessionCompat(context, TAG_MEDIA_PLAYER).apply {
            setMediaButtonReceiver(null)
            setCallback(callback)
            setSessionActivity(activityIntent)
            setMediaButtonReceiver(mediaBtnIntent)
        }
    }
}