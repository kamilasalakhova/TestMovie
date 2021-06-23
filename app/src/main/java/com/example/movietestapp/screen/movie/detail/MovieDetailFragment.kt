package com.example.movietestapp.screen.movie.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movietestapp.R
import com.example.movietestapp.base.App
import com.example.movietestapp.base.App.Companion.const
import com.example.movietestapp.data.models.MovieCast
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.utils.alertDialog
import com.example.movietestapp.databinding.FragmentMovieDetailBinding
import com.example.movietestapp.screen.base.listeners.OnActorItemClickListener
import com.example.movietestapp.screen.movie.actor.adapter.ActorDetailAdapter
import com.example.movietestapp.screen.movie.detail.adapter.MovieDetailAdapter
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailUI
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class MovieDetailFragment: Fragment(), OnActorItemClickListener {

    private val moviesViewModel: MovieDetailViewModel by viewModels{ App.appComponent.movieDetailViewModelFactory()}
    private var _binding: FragmentMovieDetailBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.back.setOnClickListener {
            if (!findNavController().popBackStack()) {
                activity?.finish()
            }
        }

        moviesViewModel.addId(arguments?.getInt(const.BUNDLE_MOVIE_ID))
        initListView()
        collectUiState()
        return root
    }

    private fun initListView() {
        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = MovieDetailAdapter(this)
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.movieDetail.collect { moviesResponce ->
                when(moviesResponce.status){
                    Resource.Status.SUCCESS -> {
                        binding.progressBarContainer.visibility = View.GONE
                        moviesResponce.data?.let { displayMovie(it) }
                    }
                    Resource.Status.ERROR -> {
                        activity?.let { alertDialog(it, moviesResponce.message ?: "", getString(R.string.ok), null) }
                    }
                    Resource.Status.LOADING -> {
                        binding.progressBarContainer.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun displayMovie(data: MovieDetailUI) {
        Glide.with(App.context)
            .load("${const.IMAGE_URL}${data.backdrop}")
            .apply(
                RequestOptions()
                .centerInside()
                .placeholder(R.drawable.ic_launcher_foreground))
            .into(binding.logo )
        binding.name.text = data.title
        binding.releaseDate.text = data.releaseDate
        (binding.list.adapter as MovieDetailAdapter).itemList = data.details ?: listOf()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: MovieCast?) {
        movie?.id?.let {
            val directions = MovieDetailFragmentDirections.actionMovieDetailFragmentToMovieActorFragment(it)
            findNavController().navigate(directions)
        }
    }
}
