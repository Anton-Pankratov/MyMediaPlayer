package net.app.mymediaplayer.media.playlist

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlaylistControllerImpl(private val context: Context) : PlaylistController {

    private var _playlist: List<SoundTrack>? = null

    override val playlist: List<SoundTrack>
        get() = requireNotNull(_playlist)

    val images = HashMap<String, Bitmap>(playlist.size)

    val countTracks = playlist.size
    val maxTrackIndex = playlist.size - 1

    val currentTrackIndex = 0

    var currentTrack = playlist[0]
        get() = playlist[currentTrackIndex]
        private set

    override fun nextTrack(): SoundTrack {
        TODO("Not yet implemented")
    }

    override fun previousTrack(): SoundTrack {
        TODO("Not yet implemented")
    }

    override fun parseTracks() {
        _playlist = formJsonAdapter().decodePlaylist().also { tracks ->
            tracks?.formSoundtrackImages()
        }
    }

    override fun List<SoundTrack>.formSoundtrackImages() {
        CoroutineScope(Dispatchers.Default).launch {
            try {
                forEach { track ->
                    track.bitmapUri.apply {
                        images[this] = formImageFromUri()
                    }
                }
            } catch (e: Exception) { }
        }
    }

    override fun String.formImageFromUri(): Bitmap {
        return Glide.with(context)
            .asBitmap()
            .load(this)
            .submit(200, 200)
            .get()
    }

    override fun JsonAdapter<List<SoundTrack>>.decodePlaylist(): List<SoundTrack>? {
        return fromJson(
            context.assets.open("playlist.json")
                .bufferedReader().use { it.readText() }
        )
    }

    override fun formJsonAdapter(): JsonAdapter<List<SoundTrack>> {
        return Moshi.Builder().build()
            .adapter(
                Types.newParameterizedType(
                    List::class.java, SoundTrack::class.java
                )
            )
    }
}