package com.example.movietestapp.screen.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.movietestapp.R
import com.example.movietestapp.base.App.Companion.const
import com.example.movietestapp.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = Bundle()
        intent?.extras?.getInt(const.BUNDLE_MOVIE_ID)?.let {
            bundle.putInt(const.BUNDLE_MOVIE_ID, it)
        }
        val nav = findNavController(R.id.nav_host_fragment_activity_movie)
        nav.setGraph(R.navigation.movie_navigation, bundle )

    }
}