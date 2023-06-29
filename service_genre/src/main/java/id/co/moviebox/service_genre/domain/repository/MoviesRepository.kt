package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.Genre

interface MoviesRepository {
    suspend fun getGenres(): List<Genre>

    suspend fun getMoviesByGenre(genreID: String): List<MovieDto>
    suspend fun getUser(username: String): DetailUser
}