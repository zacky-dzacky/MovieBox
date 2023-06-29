package id.co.moviebox.service_genre.data.api.service

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.service_genre.data.api.dto.DetailUserDto
import id.co.moviebox.service_genre.data.api.dto.SearchUserDto
import id.co.moviebox.service_genre.data.api.dto.GenresDto
import id.co.moviebox.service_genre.data.api.dto.MoviesByGenreDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
//    @Headers("accept: application/json")
    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2N2FmYWE5NDBjYjkyNTk3NTRiNDFhNTMwZjQ0ZDk4MyIsInN1YiI6IjY0OWFjNWU2N2UzNDgzMDBmZjgyODQ0NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.GdlulVbKr6oqlPyPrjMqefYBgNAQDRQLEf5ntBNmXGg")
    @GET("genre/movie/list?language=en")
    suspend fun getGenres(
    ) : GenresDto

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2N2FmYWE5NDBjYjkyNTk3NTRiNDFhNTMwZjQ0ZDk4MyIsInN1YiI6IjY0OWFjNWU2N2UzNDgzMDBmZjgyODQ0NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.GdlulVbKr6oqlPyPrjMqefYBgNAQDRQLEf5ntBNmXGg")
    @GET("movie/{genre_id}/lists?language=en-US")
    suspend fun getMoviesByGenre(
        @Path("genre_id") genreID: String,
        @Query("page") page: Int
    ) : MoviesByGenreDto

    @GET("users/{username}")
    suspend fun getUsersByUsername(@Path("username") idUser: String): DetailUserDto

    @GET("search/users")
    suspend fun searchUserByName(@Query("q") query: String): ResultDto<SearchUserDto>

    @GET("search/users")
    suspend fun searchUserByName(@Query("q") query: String, @Query("page")index: Int): ResultDto<SearchUserDto>

    @GET("user_favorites")
    fun getUserFavorites(): Result<Any>
}