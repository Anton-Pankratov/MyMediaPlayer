package net.app.mymediaplayer

import android.app.Application
import net.app.mymediaplayer.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyMediaPlayerApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyMediaPlayerApp)
            modules(appModule)
        }
    }
}