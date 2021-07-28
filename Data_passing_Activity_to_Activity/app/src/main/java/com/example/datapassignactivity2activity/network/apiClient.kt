package com.example.datapassignactivity2activity.network


import com.example.datapassignactivity2activity.newModel.ResponseModel
import retrofit2.http.*

interface apiClient {

    @GET("shows")
    suspend fun getMovieListComedy(@Query("page") number:Int): ResponseModel

    @GET("shows?page=2")
    suspend fun getMovieListAnimation(): ResponseModel

}