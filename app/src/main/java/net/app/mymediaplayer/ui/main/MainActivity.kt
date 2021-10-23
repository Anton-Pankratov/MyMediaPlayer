package net.app.mymediaplayer.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.app.mymediaplayer.MyMediaPlayerApp
import net.app.mymediaplayer.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}