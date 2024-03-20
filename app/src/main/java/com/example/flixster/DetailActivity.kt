package com.example.flixster

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var detailMovieImage: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var ratingTextView: TextView
    private lateinit var movieDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie)

        detailMovieImage = findViewById(R.id.movie_image)
        titleTextView = findViewById(R.id.movie_title)
        ratingTextView = findViewById(R.id.movie_rating)
        movieDescription = findViewById(R.id.movie_description)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as MoviePoster

        titleTextView.text = movie.title
        ratingTextView.text = movie.vote_average.toString()
        movieDescription.text = movie.description

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500/" + movie.movieImageUrl)
            .into(detailMovieImage)
    }
}