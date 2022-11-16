package com.example.a203110026_fani_anggita_retrofit_p9

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}