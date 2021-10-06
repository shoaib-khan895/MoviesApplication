package com.example.movie.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieUpcomingResponse(
    @SerializedName("results")
    val upcoming: List<MovieUpcoming>

    ) : Parcelable
