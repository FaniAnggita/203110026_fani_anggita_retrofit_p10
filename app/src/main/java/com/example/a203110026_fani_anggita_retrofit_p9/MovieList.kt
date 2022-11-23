package com.example.a203110026_fani_anggita_retrofit_p9


import com.google.gson.annotations.SerializedName

// TODO 7: Bagian untuk parsing data json hasil response
data class MovieList(@SerializedName("Search") val List : List<Movie>)