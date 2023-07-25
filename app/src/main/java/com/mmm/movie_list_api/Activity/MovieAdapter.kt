package com.mmm.movie_list_api.Activity

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.mmm.movie_list_api.ApiMovie.ApiClient
import com.mmm.movie_list_api.Model.ResultsItem
import com.mmm.movie_list_api.databinding.MoviesItemBinding

class MovieAdapter :Adapter<MovieAdapter.MovieHolder>(){

    lateinit var movielist: List<ResultsItem?>
    lateinit var context: Context

    class MovieHolder(itemView: MoviesItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {

        context = parent.context
        var binding = MoviesItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieHolder(binding)
    }

    override fun getItemCount(): Int {

        return movielist.size
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {

        holder.binding.apply {

            movielist.get(position)?.apply {

                Glide.with(context).load(ApiClient.posterUrl+posterPath).into(imgMovie)
                txtTitle.text = originalTitle
                txtDescription.text = overview
                txtRateing.text = voteAverage.toString()

            }
        }
    }

    fun setmovies(movielist: List<ResultsItem?>?) {
        this.movielist = movielist as List<ResultsItem?>
    }

}