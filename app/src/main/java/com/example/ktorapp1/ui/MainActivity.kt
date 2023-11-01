package com.example.ktorapp1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import com.example.ktorapp1.data.network.Resource
import com.example.ktorapp1.ui.theme.AppTheme
import com.example.ktorapp1.ui.common.FullScreenProgressBar
import com.example.ktorapp1.ui.common.toast
import com.example.ktorapp1.ui.movies.MovieList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val movies = viewModel.movies.collectAsState()

            AppTheme {
                movies.value?.let {
                    when (it) {
                        is Resource.Failure -> {
                            context.toast(it.exception.message!!)
                        }
                        Resource.Loading -> {
                            FullScreenProgressBar()
                        }
                        is Resource.Success -> {
                            MovieList(it.result)
                        }
                    }
                }
            }

        }
    }
}
