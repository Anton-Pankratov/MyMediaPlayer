package net.app.mymediaplayer.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import net.app.mymediaplayer.databinding.FragmentTracksBinding
import net.app.mymediaplayer.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class TracksFragment : BaseFragment<TracksViewModel, FragmentTracksBinding>() {

    override val viewModel: TracksViewModel by viewModel()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTracksBinding
        get() = FragmentTracksBinding::inflate
}