package com.example.a203110026_fani_anggita_retrofit_p9

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// TODO 6: Bagian untuk request ke webservice
interface RetrofitService {

    // untuk mendapatkan value dari API dengan cara mengirimkan request
    @GET("api?s=batman")
    fun getAllMovies(): Call<MovieList>

    companion object {

        var retrofitService: RetrofitService? = null

        // TODO 8: Bagian untuk load url gambar
        fun getInstance(): RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://fake-movie-database-api.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}