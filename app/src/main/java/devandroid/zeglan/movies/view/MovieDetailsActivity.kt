package devandroid.zeglan.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import devandroid.zeglan.movies.R
import devandroid.zeglan.movies.databinding.ActivityMovieDetailsBinding
import devandroid.zeglan.movies.viewmodel.MovieDetailViewModel

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var viewModel: MovieDetailViewModel
    private var movieId = 550

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        viewModel = ViewModelProvider(this)[MovieDetailViewModel::class.java]

        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadMovie()
        observe()

    }

    private fun loadMovie() {
        val bundle = intent.extras
        if (bundle != null) {
            movieId = bundle.getInt("movieId")
            viewModel.getMovieDetail(movieId)
        }
    }

    private fun observe() {
        viewModel.movie.observe(this, Observer {
            binding.textTitle.text = it.title
            val imageView = binding.imgMoviePoster
            Glide.with(applicationContext).load("https://image.tmdb.org/t/p/w342${it.poster_path}").into(imageView)
        })

    }



}