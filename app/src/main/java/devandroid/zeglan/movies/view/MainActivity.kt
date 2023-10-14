package devandroid.zeglan.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import devandroid.zeglan.movies.R
import devandroid.zeglan.movies.databinding.ActivityMainBinding
import devandroid.zeglan.movies.server.model.GenreListModel
import devandroid.zeglan.movies.view.adapter.MainAdapter
import devandroid.zeglan.movies.viewmodel.MainViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private var mainAdapter: MainAdapter = MainAdapter()
    private var genresList = listOf<GenreListModel.GenreModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.mainRecyclerView.adapter = mainAdapter

        //viewModel.getGenres()
        viewModel.filteredMovies("Ação","28")
        viewModel.filteredMovies("Terror","27")
        viewModel.filteredMovies("Aventura","12")
        viewModel.filteredMovies("Animação","16")
        viewModel.filteredMovies("Comédia","35")
        viewModel.filteredMovies("Crime","80")
        viewModel.filteredMovies("Documentário","99")
        viewModel.filteredMovies("Drama","18")
        viewModel.filteredMovies("Família","10751")
        viewModel.filteredMovies("Fantasia","14")
        viewModel.filteredMovies("História","36")
        viewModel.filteredMovies("Música","10402")
        viewModel.filteredMovies("Mistério","9648")
        viewModel.filteredMovies("Romance","10749")
        viewModel.filteredMovies("Ficção científica","878")
        viewModel.filteredMovies("Cinema TV","10770")
        viewModel.filteredMovies("Thriller","53")
        viewModel.filteredMovies("Guerra","10752")
        viewModel.filteredMovies("Faroeste","37")

//        viewModel.getFilteredMovies(genresList)
        observe()

    }

    private fun observe() {
        viewModel.genreList.observe(this) {
            genresList = it
        }

        viewModel.movieListWithGenre.observe(this){
            mainAdapter.update(it)
        }

    }



}