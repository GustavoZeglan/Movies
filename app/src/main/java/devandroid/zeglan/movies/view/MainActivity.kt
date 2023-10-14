package devandroid.zeglan.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.zeglan.movies.R
import devandroid.zeglan.movies.databinding.ActivityMainBinding
import devandroid.zeglan.movies.server.model.GenreListModel
import devandroid.zeglan.movies.server.repository.local.GenreListMock
import devandroid.zeglan.movies.view.adapter.MainAdapter
import devandroid.zeglan.movies.viewmodel.MainViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var mainAdapter: MainAdapter = MainAdapter()
    //private var genresList = listOf<GenreListModel.GenreModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainRecyclerView.adapter = mainAdapter


        getFilteredMovies(GenreListMock.list)
        observe()

    }

    private fun observe() {
//        viewModel.genreList.observe(this) {
//            genresList = it
//        }
        viewModel.movieListWithGenre.observe(this){
            mainAdapter.update(it)
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