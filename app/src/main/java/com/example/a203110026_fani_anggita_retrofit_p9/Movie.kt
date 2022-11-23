package com.example.a203110026_fani_anggita_retrofit_p9

import com.google.gson.annotations.SerializedName

// TODO 5: Class Data
data class Movie(
    // set member class beserta tipe datanya
    @SerializedName("Title") val title: String,
    @SerializedName("Poster") val poster: String,
    val imdbID: String,
    @SerializedName("Year") val year: String
)