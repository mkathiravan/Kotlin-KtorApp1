package com.example.ktorapp1.ui.movies

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ktorapp1.data.models.Movie

@Composable
fun MovieList(movies: List<Movie>) {
    Surface(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(movies) { item ->
                MovieItem(item)
            }
        }
    }
}