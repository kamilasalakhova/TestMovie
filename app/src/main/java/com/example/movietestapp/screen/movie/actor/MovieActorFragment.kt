package com.example.movietestapp.screen.movie.actor

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
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.utils.alertDialog
import com.example.movietestapp.databinding.FragmentActorBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.tabs.upcoming.adapter.UpcomingAdapter
import com.example.movietestapp.screen.movie.actor.adapter.ActorDetailAdapter
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailUI
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieActorFragment: Fragment(), OnItemClickListener {

    private val moviesViewModel: MovieActorViewModel by viewModels{ App.appComponent.movieActorViewModelFactory()}
    private var _binding: FragmentActorBinding? = null
    
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentActorBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        moviesViewModel.addId(arguments?.getInt(App.const.BUNDLE_MOVIE_ID))

        initListView()
        collectUiState()
        return root
    }

    private fun initListView() {
        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = ActorDetailAdapter(this)
    }

    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.actorDetail.collect { actorResponce ->
                when(actorResponce.status){
                    Resource.Status.SUCCESS -> {
                        binding.progressBarContainer.visibility = View.GONE
                        actorResponce.data?.let { displayActor(it) }
                    }
                    Resource.Status.ERROR -> {
                        activity?.let { alertDialog(it, actorResponce.message ?: "", getString(R.string.ok), null) }
                    }
                    Resource.Status.LOADING -> {
                        binding.progressBarContainer.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun displayActor(data: ActorDetailUI) {
        Glide.with(App.context)
            .load("${App.const.IMAGE_URL}${data.image}")
            .apply(
                RequestOptions()
                    .centerInside()
                    .placeholder(R.drawable.ic_launcher_foreground))
            .into(binding.logo )
        binding.name.text = data.name
        binding.releaseDate.text = data.birthday
        (binding.list.adapter as ActorDetailAdapter).itemList = data.details ?: listOf()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: MovieInList?) {
        movie?.id?.let {
            val directions = MovieActorFragmentDirections.actionMovieActorFragmentToMovieDetailFragment(it)
            findNavController().navigate(directions)
        }
    }
}
