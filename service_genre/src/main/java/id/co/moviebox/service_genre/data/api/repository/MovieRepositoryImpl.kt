package id.co.moviebox.service_genre.data.api.repository

import android.content.Context
import id.co.moviebox.base_component.model.Result
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.data.api.mapper.DetailMovieMapper
import id.co.moviebox.service_genre.data.api.mapper.GenresDtoMapper
import id.co.moviebox.service_genre.data.api.service.MoviesApi
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.domain.entity.DetailMovie
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.repository.MoviesRepository

class MovieRepositoryImpl(
    private val context: Context,
    private val userApi: MoviesApi,
    private val genresDtoMapper: GenresDtoMapper,
    private val detailMovieMapper: DetailMovieMapper,
    private val userLocalDao: UserLocalDao,
    private val usersLocalMapper: UsersLocalMapper
) : MoviesRepository {
    override suspend fun getGenres(): List<Genre> {

        return genresDtoMapper(userApi.getGenres().genres)
    }

    override suspend fun getMoviesByGenre(genreID: String): List<MovieDto> {
        TODO("Not yet implemented")
    }


    override suspend fun getDetailMovie(moviesID: String): DetailMovie {
        return detailMovieMapper(userApi.getDetailMoviesByID(moviesID))
    }
}