package com.example.datapassignactivity2activity.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.datapassignactivity2activity.newModel.ResponseModel
import com.example.datapassignactivity2activity.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MovieViewModel(val respository: MovieRepository) : ViewModel() {
/*
getting response from Repository
 */

    fun movieLiveData(num:Int): LiveData<ResponseModel>{
        return liveData(Dispatchers.IO){
            val result=respository.getMovieList(num)
            emit(result.data!!)
        }
    }
}