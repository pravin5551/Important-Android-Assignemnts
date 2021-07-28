package com.example.datapassignactivity2activity.newModel


import com.google.gson.annotations.SerializedName

data class WebChannel(
    @SerializedName("country")
    var country: CountryX,
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String
)