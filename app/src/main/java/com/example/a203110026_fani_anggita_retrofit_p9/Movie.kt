package com.example.a203110026_fani_anggita_retrofit_p9

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val poster: String,
    val imdbID: String,
    @SerializedName("Year") val year: String
)