package id.co.moviebox.service_genre.data.api.repository

import android.content.Context
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.data.api.mapper.UserDtoMapper
import id.co.moviebox.service_genre.data.api.mapper.GenresDtoMapper
import id.co.moviebox.service_genre.data.api.service.UserApi
import id.co.moviebox.service_genre.data.local.dao.UserLocalDao
import id.co.moviebox.service_genre.data.local.mapper.UsersLocalMapper
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.Genre
import id.co.moviebox.service_genre.domain.repository.MoviesRepository

class MovieRepositoryImpl(
    private val context: Context,
    private val userApi: UserApi,
    private val genresDtoMapper: GenresDtoMapper,
    private val userDtoMapper: UserDtoMapper,
    private val userLocalDao: UserLocalDao,
    private val usersLocalMapper: UsersLocalMapper
) : MoviesRepository {
    override suspend fun getGenres(): List<Genre> {

        return genresDtoMapper(userApi.getGenres().genres)
    }

    override suspend fun getMoviesByGenre(genreID: String): List<MovieDto> {
        TODO("Not yet implemented")
    }


    override suspend fun getUser(username: String): DetailUser {
        return userDtoMapper(context, userApi.getUsersByUsername(username))
    }
}