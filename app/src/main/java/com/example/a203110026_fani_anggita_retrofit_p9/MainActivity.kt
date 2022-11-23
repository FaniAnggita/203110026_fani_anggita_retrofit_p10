package com.example.a203110026_fani_anggita_retrofit_p9


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a203110026_fani_anggita_retrofit_p9.databinding.ActivityMainBinding
import com.example.a203110026_fani_anggita_retrofit_p9.MainViewModel

// TODO 1: Class View (Activity)
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding

    lateinit var viewModel: MainViewModel

    // Menginisialisasi kelas RetrofitService
    private val retrofitService = RetrofitService.getInstance()

    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //mendapatkan viewmodel instance dengan MyViewModelFactory
        viewModel =
            ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )

       // TODO 2: Bagian Recyclerview
        binding.recyclerview.adapter = adapter

        // meng-generate viewmodel movielist ke adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "movieList: $it")
            adapter.setMovieList(it)
        })

        // meng-generate viewmodel pesan error
        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })

        //  // meng-generate viewmodel semua item movie
        viewModel.getAllMovies()
    }
}