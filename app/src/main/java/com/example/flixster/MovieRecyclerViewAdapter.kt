package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flixster.R.id


class MovieRecyclerViewAdapter(
    private val movies: List<MoviePoster>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.poster_display, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: MoviePoster? = null
        val mMovieTitle: TextView = mView.findViewById<View>(id.movie_title) as TextView
//        val mMovieRanking: TextView = mView.findViewById<View>(id.ranking) as TextView
        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(id.movie_image) as ImageView
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.mItem = movie
        holder.mMovieTitle.text = movie.title
        holder.mMovieDescription.text = movie.description
//        holder.mMovieRanking.text = movie.rank.toString()

//        holder.mView.setOnClickListener {
//            holder.mItem?.let { movie ->
//                mListener?.onItemClick(movie)
//            }
//        }

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/${movie.movieImageUrl}")
            .centerInside()
            .into(holder.mMovieImage)
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }
}