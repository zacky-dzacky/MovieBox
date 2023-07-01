package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.DetailMovie
import id.co.moviebox.service_genre.domain.entity.Genre

interface MoviesRepository {
    suspend fun getGenres(): List<Genre>

    suspend fun getMoviesByGenre(genreID: String): List<MovieDto>
    suspend fun getDetailMovie(username: String): DetailMovie
}