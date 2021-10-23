package net.app.mymediaplayer.ui.selected

import android.view.LayoutInflater
import android.view.ViewGroup
import net.app.mymediaplayer.databinding.FragmentSelectedTrackBinding
import net.app.mymediaplayer.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class SelectedTrackFragment : BaseFragment<SelectedTrackViewModel, FragmentSelectedTrackBinding>() {

    override val viewModel: SelectedTrackViewModel by viewModel()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSelectedTrackBinding
        get() = FragmentSelectedTrackBinding::inflate


}