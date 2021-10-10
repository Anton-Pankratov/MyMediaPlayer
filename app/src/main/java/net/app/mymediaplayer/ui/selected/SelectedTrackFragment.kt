package net.app.mymediaplayer.ui.selected

import android.view.LayoutInflater
import android.view.ViewGroup
import net.app.mymediaplayer.databinding.FragmentSelectedTrackBinding
import net.app.mymediaplayer.ui.base.BaseFragment

class SelectedTrackFragment : BaseFragment<FragmentSelectedTrackBinding, SelectedTrackViewModel>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectedTrackBinding
        get() = FragmentSelectedTrackBinding::inflate

    override val viewModel: SelectedTrackViewModel
        get() = SelectedTrackViewModel()


}