package com.example.movie.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieUpcoming(
    @SerializedName("id")
    val id: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("release_date")
    val release: String?,
    @SerializedName("overview")
    val desc: String

) : Parcelable {
    constructor() : this("", "", "", "","")
}