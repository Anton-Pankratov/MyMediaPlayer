package net.app.mymediaplayer.media.playlist

import android.content.Context
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

    override fun parseTracks() {
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, SoundTrack::class.java)
        val adapter: JsonAdapter<List<SoundTrack>> = moshi.adapter(type)
        val file = context.assets.open("playlist.json").bufferedReader().use { it.readText() }
        _playlist = adapter.fromJson(file)

        CoroutineScope(Dispatchers.Default).launch {
            try {
                _playlist?.forEach {

                }
            } catch (e: Exception) {}
        }
    }
}