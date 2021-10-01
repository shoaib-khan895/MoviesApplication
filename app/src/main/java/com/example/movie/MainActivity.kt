package com.example.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.adapter.MovieAdapter
import com.example.movie.adapter.UpcomingAdapter
import com.example.movie.models.Movie
import com.example.movie.models.MovieResponse
import com.example.movie.models.MovieUpcoming
import com.example.movie.models.MovieUpcomingResponse
import com.example.movie.services.MovieApiInterface
import com.example.movie.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn_popular -> {
                    // Respond to navigation item 1 click
                    blank_text.visibility = View.GONE
                    rv_movies_list.layoutManager = LinearLayoutManager(this)
                    rv_movies_list.setHasFixedSize(true)
                    tv_sub_title.setText(R.string.popular)
                    getMovieData { movies: List<Movie> ->
                        rv_movies_list.adapter = MovieAdapter(movies)
                    }
                    true
                }
                R.id.btn_upcoming -> {
                    blank_text.visibility = View.GONE
                    // Respond to navigation item 2 click
                    rv_movies_list.layoutManager = LinearLayoutManager(this)
                    rv_movies_list.setHasFixedSize(true)
                    tv_sub_title.setText(R.string.Up_Coming)
                    getUpcomingMovieData { upcoming: List<MovieUpcoming> ->
                        rv_movies_list.adapter = UpcomingAdapter(upcoming)
                    }
                    true
                }
                else -> false
            }
        }
    }

    private fun getUpcomingMovieData(Callback: (List<MovieUpcoming>) -> Unit) {
        val apiServices =
            MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiServices.getUpcomingList().enqueue(object : Callback<MovieUpcomingResponse> {
            override fun onResponse(
                call: Call<MovieUpcomingResponse>,
                response: Response<MovieUpcomingResponse>
            ) {
                return Callback(response.body()!!.upcoming)
            }

            override fun onFailure(call: Call<MovieUpcomingResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun getMovieData(Callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>, response: Response<MovieResponse>
            ) {
                return Callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }


}


