package com.example.movietestapp.screen.main.tabs.top_rated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietestapp.base.App
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.FragmentTopRatedBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.MainViewModel
import com.example.movietestapp.screen.main.tabs.popular.adapter.PopularAdapter
import com.example.movietestapp.screen.main.tabs.top_rated.adapter.TopRatedAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class TopRatedFragment : Fragment(), OnItemClickListener {

    private val moviesViewModel: MainViewModel by activityViewModels{ App.appComponent.mainViewModelFactory() }
    private var _binding: FragmentTopRatedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopRatedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListView()
        collectUiState()

        return root
    }
    private fun initListView() {
        binding.list.layoutManager = LinearLayoutManager(activity)
        binding.list.adapter = TopRatedAdapter(this)
        binding.list.addItemDecoration(DividerItemDecoration(activity, DividerItemDecoration.VERTICAL))
    }


    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.topRatedPagedList?.collectLatest { movies ->
                (binding.list.adapter as TopRatedAdapter).submitData(movies)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: MovieInList?) {
        movie?.id?.let {
            val directions = TopRatedFragmentDirections.actionNavigationTopRatedToMovieActivity(it)
            findNavController().navigate(directions)
        }
    }
}