package com.example.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.adapter.UpcomingAdapter
import com.example.movie.models.MovieUpcoming
import com.example.movie.models.MovieUpcomingResponse
import com.example.movie.services.MovieApiInterface
import com.example.movie.services.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.upcoming_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UpcomingData : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.upcoming_data, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       // blank_text.visibility = View.GONE
        // Respond to navigation item 2 click
        rv_movies_list.layoutManager = LinearLayoutManager(activity)
        rv_movies_list.setHasFixedSize(true)
        tv_sub_title.setText(R.string.Up_Coming)
        getUpcomingMovieData { upcoming: List<MovieUpcoming> ->
            rv_movies_list.adapter = UpcomingAdapter(upcoming)
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
}