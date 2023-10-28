package devandroid.zeglan.movies.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.zeglan.movies.databinding.FragmentWatchListBinding
import devandroid.zeglan.movies.view.adapter.WatchListAdapter
import devandroid.zeglan.movies.view.listener.OnMovieListener
import devandroid.zeglan.movies.viewmodel.WatchListViewModel

class WatchListFragment : Fragment() {

    private lateinit var viewModel: WatchListViewModel
    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!

    private val adapter = WatchListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        viewModel = ViewModelProvider(this)[WatchListViewModel::class.java]
        _binding = FragmentWatchListBinding.inflate(inflater,container, false)

        binding.recyclerDetailedMovies.layoutManager = LinearLayoutManager(context)
        binding.recyclerDetailedMovies.adapter = adapter

        val listener = object : OnMovieListener {
            override fun onClick(movieId: Int) {

                val action = WatchListFragmentDirections.actionWatchFragmentToMovieDetailsFragment(movieId)
                findNavController().navigate(action)

            }
        }

        adapter.attachListener(listener)

        viewModel.getWatchList()
        observe()

        return binding.root

    }

    private fun observe() {
        viewModel.watchlist.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })

    }


}