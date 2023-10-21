package devandroid.zeglan.movies.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.zeglan.movies.databinding.FragmentHomeBinding
import devandroid.zeglan.movies.server.model.GenreListModel
import devandroid.zeglan.movies.server.repository.local.GenreListMock
import devandroid.zeglan.movies.view.adapter.MainAdapter
import devandroid.zeglan.movies.view.listener.OnMovieListener
import devandroid.zeglan.movies.viewmodel.HomeViewModel


class HomeFragment : Fragment(){

    private lateinit var viewModel: HomeViewModel

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var adapter = MainAdapter()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {

        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        _binding = FragmentHomeBinding.inflate(inflater,container, false)

        binding.mainRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.mainRecyclerView.adapter = adapter


        val listener = object : OnMovieListener {
            override fun onClick(movieId: Int) {

                val screen = Intent(context, MovieDetailsActivity::class.java)

                val bundle = Bundle()
                bundle.putInt("movieId", movieId)
                screen.putExtras(bundle)

                startActivity(screen)
            }
        }

        adapter.attachListener(listener)


        getFilteredMovies(GenreListMock.list)
        observe()


        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
//        viewModel.genreList.observe(this) {
//            genresList = it
//        }
        viewModel.movieListWithGenre.observe(viewLifecycleOwner){
            adapter.update(it)
        }

    }

    private fun getFilteredMovies(genresList: List<GenreListModel.GenreModel>) {
        for (i in 0 until genresList.count()) {
            val genreId = genresList[i].id
            val genreName = genresList[i].name

            viewModel.filteredMovies(genreId,genreName)
        }
    }


}