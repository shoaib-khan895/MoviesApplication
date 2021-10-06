package com.example.movie.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.models.MovieUpcoming
import com.example.movie.models.MovieUpcomingResponse
import com.example.movie.network.MovieApiInterface
import com.example.movie.network.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpcomingViewModel : ViewModel() {

    private var upComingMovieList: MutableLiveData<List<MovieUpcoming>> =
        MutableLiveData<List<MovieUpcoming>>()

    fun getupComingMovieList() = upComingMovieList

    fun getUpcomingMovieData() {
        val apiServices =
            MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiServices.getUpcomingList().enqueue(object : Callback<MovieUpcomingResponse> {
            override fun onResponse(
                call: Call<MovieUpcomingResponse>,
                response: Response<MovieUpcomingResponse>
            ) {
                upComingMovieList.postValue(response.body()!!.upcoming)
            }

            override fun onFailure(call: Call<MovieUpcomingResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}