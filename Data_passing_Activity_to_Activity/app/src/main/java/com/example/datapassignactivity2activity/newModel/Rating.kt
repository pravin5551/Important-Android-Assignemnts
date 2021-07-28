package com.example.datapassignactivity2activity.newModel


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("average")
    var average: Double
)