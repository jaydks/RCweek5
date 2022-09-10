package com.example.rcweek5

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rcweek5.databinding.ItemMovieBinding

class MovieAdapter : androidx.recyclerview.widget.ListAdapter<DailyBoxOffice, MovieAdapter.MovieViewHolder>(
    MovieCallback) {

    class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: DailyBoxOffice) = with(binding){
            tvMovie.text = movie.movieNm
            tvRank.text = movie.rank
            tvBookrate.text = "예매율 ${movie.salesShare}%  ·"
        }
    }
    companion object {
        private val MovieCallback = object : DiffUtil.ItemCallback<DailyBoxOffice>(){
            override fun areItemsTheSame(
                oldItem: DailyBoxOffice,
                newItem: DailyBoxOffice
            ): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(
                oldItem: DailyBoxOffice,
                newItem: DailyBoxOffice
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder:MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}