package com.example.a203110026_fani_anggita_retrofit_p9
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a203110026_fani_anggita_retrofit_p9.databinding.LayoutRvItemBinding

// TODO 3: Class Adapter
class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    // variabel untuk menerima mutable list movie
    var movies = mutableListOf<Movie>()

    // fungsi ini akan mengembalikan mutable list movie
    fun setMovieList(movies: List<Movie>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutRvItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    // TODO 9: Bagian untuk menampilkan gambar
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title
        Glide.with(holder.itemView.context).load(movie.poster)
            .into(holder.binding.moviePoster)

    }

    override fun getItemCount(): Int {
        return movies.size
    }
}

class MainViewHolder(val binding: LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {}