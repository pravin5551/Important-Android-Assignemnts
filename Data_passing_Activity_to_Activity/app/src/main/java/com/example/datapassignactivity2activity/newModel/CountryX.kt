package com.example.datapassignactivity2activity.newModel


import com.google.gson.annotations.SerializedName

data class CountryX(
    @SerializedName("code")
    var code: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("timezone")
    var timezone: String
)