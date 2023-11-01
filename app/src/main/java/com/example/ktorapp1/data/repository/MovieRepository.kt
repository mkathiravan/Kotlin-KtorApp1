package com.example.ktorapp1.data.repository

import com.example.ktorapp1.data.network.Resource
import com.example.ktorapp1.data.models.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): Resource<List<Movie>>
}