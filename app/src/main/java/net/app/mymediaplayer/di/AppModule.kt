package net.app.mymediaplayer.di

import net.app.mymediaplayer.player.MediaPlayer
import net.app.mymediaplayer.player.MediaPlayerImpl
import net.app.mymediaplayer.repository.MediaPlayerRepository
import net.app.mymediaplayer.repository.MediaPlayerRepositoryImpl
import net.app.mymediaplayer.ui.main.MainViewModel
import net.app.mymediaplayer.ui.selected.SelectedTrackViewModel
import net.app.mymediaplayer.ui.tracks.TracksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory<MediaPlayerRepository> { MediaPlayerRepositoryImpl() }

    factory<MediaPlayer> { MediaPlayerImpl(get()) }

    viewModel { MainViewModel(get()) }
    viewModel { SelectedTrackViewModel(get()) }
    viewModel { TracksViewModel(get()) }
}