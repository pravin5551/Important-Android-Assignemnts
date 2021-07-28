package com.example.datapassignactivity2activity.repository

import com.example.itunesusingmvvm.Models.Netrork.API.Network
import com.example.datapassignactivity2activity.network.Resource
import com.example.datapassignactivity2activity.network.ResponseHandler
import com.example.datapassignactivity2activity.network.apiClient
import com.example.datapassignactivity2activity.newModel.ResponseModel


class MovieRepository {

    val api = Network.getInstance()
        .create(apiClient::class.java)
    val responseHandler = ResponseHandler()

    suspend fun getMovieList( num:Int): Resource<ResponseModel> {
            val data=api.getMovieListComedy(num)
            return responseHandler.handleSuccess(data)
        }
    }
