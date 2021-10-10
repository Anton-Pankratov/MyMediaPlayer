package net.app.mymediaplayer.ui.tracks

import android.view.LayoutInflater
import android.view.ViewGroup
import net.app.mymediaplayer.databinding.FragmentTracksBinding
import net.app.mymediaplayer.ui.base.BaseFragment

class TracksFragment : BaseFragment<FragmentTracksBinding, TracksViewModel>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTracksBinding
        get() = FragmentTracksBinding::inflate

    override val viewModel: TracksViewModel
        get() = TracksViewModel()
}