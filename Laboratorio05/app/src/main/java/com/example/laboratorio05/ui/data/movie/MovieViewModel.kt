package com.example.laboratorio05.ui.data.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.data.model.MovielModel
import com.example.laboratorio05.repository.MovieRepository
import com.example.laboratorio05.ui.MovieReviewerApplication

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    fun getMovies() = repository.getMovies()
    fun addMovie(movie: MovielModel) = repository.addMovies(movie)

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }
    }
}