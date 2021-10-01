package com.example.movie.services

import com.example.movie.models.MovieResponse
import com.example.movie.models.MovieUpcomingResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("movie/popular?api_key=046c734abad880a999c192c70aeb74dc")
    fun getMovieList(): Call<MovieResponse>

    @GET("movie/upcoming?api_key=046c734abad880a999c192c70aeb74dc")
    fun getUpcomingList(): Call<MovieUpcomingResponse>
}