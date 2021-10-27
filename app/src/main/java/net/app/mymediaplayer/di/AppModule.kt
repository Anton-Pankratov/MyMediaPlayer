package net.app.mymediaplayer.di

import android.support.v4.media.session.MediaSessionCompat
import com.google.android.exoplayer2.SimpleExoPlayer
import net.app.mymediaplayer.media.components.callback.MediaSessionCallback
import net.app.mymediaplayer.media.components.callback.MediaSessionCallbackImpl
import net.app.mymediaplayer.media.components.notification.MediaPlayerNotification
import net.app.mymediaplayer.media.components.notification.MediaPlayerNotificationImpl
import net.app.mymediaplayer.media.player.MediaPlayer
import net.app.mymediaplayer.media.player.MediaPlayerImpl
import net.app.mymediaplayer.media.components.playlist.PlaylistController
import net.app.mymediaplayer.media.components.playlist.PlaylistControllerImpl
import net.app.mymediaplayer.media.components.session.MediaSession
import net.app.mymediaplayer.media.components.session.MediaSessionImpl
import net.app.mymediaplayer.media.service.MediaBrowserService
import net.app.mymediaplayer.media.service.MediaBrowserServiceImpl
import net.app.mymediaplayer.repository.MediaPlayerRepository
import net.app.mymediaplayer.repository.MediaPlayerRepositoryImpl
import net.app.mymediaplayer.ui.main.MainViewModel
import net.app.mymediaplayer.ui.selected.SelectedTrackViewModel
import net.app.mymediaplayer.ui.tracks.TracksViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<MediaPlayer> { MediaPlayerImpl(androidContext()) }

    single<MediaSession> { MediaSessionImpl(androidContext()) }

    single<PlaylistController> { PlaylistControllerImpl(androidContext()) }

    single<MediaSessionCallback> { (player: SimpleExoPlayer) ->
        MediaSessionCallbackImpl(androidContext(), player, get())
    }
    single<MediaPlayerNotification> { (session: MediaSessionCompat) ->
        MediaPlayerNotificationImpl(androidContext(), session)
    }

    single<MediaBrowserService> { MediaBrowserServiceImpl(get()) }

    factory<MediaPlayerRepository> { MediaPlayerRepositoryImpl() }

    viewModel { MainViewModel(get()) }
    viewModel { SelectedTrackViewModel(get()) }
    viewModel { TracksViewModel(get()) }
}