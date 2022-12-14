package com.example.a203110026_fani_anggita_retrofit_p9
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO 4: Class ViewModel
class MainViewModel(private val repository: MainRepository) : ViewModel() {

    //  set mutable list
    val movieList = MutableLiveData<List<Movie>>()
    val errorMessage = MutableLiveData<String>()

    // mengembalikan semua list movie
    fun getAllMovies() {
        val response = repository.getAllMovies()
        response.enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                movieList.postValue(response.body()?.List)
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}