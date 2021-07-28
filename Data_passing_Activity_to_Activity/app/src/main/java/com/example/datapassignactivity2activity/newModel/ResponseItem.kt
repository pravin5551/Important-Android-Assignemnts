package com.example.datapassignactivity2activity.newModel


import com.google.gson.annotations.SerializedName

data class ResponseItem(
    @SerializedName("averageRuntime")
    var averageRuntime: Int,
    @SerializedName("dvdCountry")
    var dvdCountry: Any,
    @SerializedName("externals")
    var externals: Externals,
    @SerializedName("genres")
    var genres: List<String>,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: Image,
    @SerializedName("language")
    var language: String,
    @SerializedName("_links")
    var links: Links,
    @SerializedName("name")
    var name: String,
    @SerializedName("network")
    var network: Network,
    @SerializedName("officialSite")
    var officialSite: String,
    @SerializedName("premiered")
    var premiered: String,
    @SerializedName("rating")
    var rating: Rating,
    @SerializedName("runtime")
    var runtime: Int,
    @SerializedName("schedule")
    var schedule: Schedule,
    @SerializedName("status")
    var status: String,
    @SerializedName("summary")
    var summary: String,
    @SerializedName("type")
    var type: String,
    @SerializedName("updated")
    var updated: Int,
    @SerializedName("url")
    var url: String,
    @SerializedName("webChannel")
    var webChannel: WebChannel,
    @SerializedName("weight")
    var weight: Int
)