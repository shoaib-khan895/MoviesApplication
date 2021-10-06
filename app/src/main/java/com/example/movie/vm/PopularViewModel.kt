package com.example.movie.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.models.Movie
import com.example.movie.models.MovieResponse
import com.example.movie.network.MovieApiInterface
import com.example.movie.network.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PopularViewModel : ViewModel() {

    private var popularMovieList: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    fun getPopularMovieList() = popularMovieList

    fun getMovieData() {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>, response: Response<MovieResponse>
            ) {
                popularMovieList.postValue(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}