package com.example.ktorapp1.data.repository

import com.example.ktorapp1.data.network.BASE_URL
import com.example.ktorapp1.data.network.Resource
import com.example.ktorapp1.data.models.Movie
import com.example.ktorapp1.data.models.PopularMovies
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import javax.inject.Inject

private const val POPULAR_MOVIES = "${BASE_URL}/popular"


class MovieRepositoryImpl @Inject constructor(private val httpClient: HttpClient) :
    MovieRepository {
    override suspend fun getPopularMovies(): Resource<List<Movie>> {
        return try {
            Resource.Success(
                httpClient.get<PopularMovies> {
                    url(POPULAR_MOVIES)
                }.movies
            )

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}