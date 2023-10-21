package devandroid.zeglan.movies.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import devandroid.zeglan.movies.R
import devandroid.zeglan.movies.databinding.ActivityMainBinding
import devandroid.zeglan.movies.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)


            val navView: BottomNavigationView = binding.navView

            val navController = findNavController(R.id.container)

            navView.setupWithNavController(navController)

        }

}