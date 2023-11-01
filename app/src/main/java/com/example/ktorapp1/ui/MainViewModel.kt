package com.example.ktorapp1.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ktorapp1.data.repository.MovieRepository
import com.example.ktorapp1.data.network.Resource
import com.example.ktorapp1.data.models.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _movies = MutableStateFlow<Resource<List<Movie>>?>(null)
    val movies: StateFlow<Resource<List<Movie>>?> = _movies

    init {
        viewModelScope.launch {
            _movies.value = Resource.Loading
            _movies.value = repository.getPopularMovies()
        }
    }
}