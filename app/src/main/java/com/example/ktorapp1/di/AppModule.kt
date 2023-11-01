package com.example.ktorapp1.di

import com.example.ktorapp1.data.repository.MovieRepositoryImpl
import com.example.ktorapp1.data.network.TmdbHttpClient
import com.example.ktorapp1.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun getHttpClient(httpClient: TmdbHttpClient): HttpClient = httpClient.getHttpClient()

    @Provides
    fun getMoviesRepository(impl: MovieRepositoryImpl): MovieRepository = impl
}
