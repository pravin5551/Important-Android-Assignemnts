package com.example.datapassignactivity2activity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.datapassignactivity2activity.repository.MovieRepository


class ViewModelFactory(val repository: MovieRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieViewModel(repository) as T
    }
}