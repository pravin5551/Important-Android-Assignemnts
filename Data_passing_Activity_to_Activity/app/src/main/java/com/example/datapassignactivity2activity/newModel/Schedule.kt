package com.example.datapassignactivity2activity.newModel


import com.google.gson.annotations.SerializedName

data class Schedule(
    @SerializedName("days")
    var days: List<String>,
    @SerializedName("time")
    var time: String
)