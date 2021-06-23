package com.example.movietestapp.screen.main.tabs.popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.movietestapp.base.App
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.FragmentListBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.MainViewModel
import com.example.movietestapp.screen.main.tabs.popular.adapter.PopularAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PopularFragment : Fragment(), OnItemClickListener {

    private val moviesViewModel: MainViewModel by activityViewModels{ App.appComponent.mainViewModelFactory() }

    private var _binding: FragmentListBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        initListView()
        collectUiState()
        return root
    }

    private fun initListView() {
        binding.list.layoutManager = GridLayoutManager(activity, 2)
        binding.list.adapter = PopularAdapter(this)
    }


    private fun collectUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            moviesViewModel.popularPagedList?.collectLatest { movies ->
                (binding.list.adapter as PopularAdapter).submitData(movies)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(movie: MovieInList?) {
        movie?.id?.let {
            val directions = PopularFragmentDirections.actionNavigationPopularToMovieActivity(it)
            findNavController().navigate(directions)
        }
    }
}