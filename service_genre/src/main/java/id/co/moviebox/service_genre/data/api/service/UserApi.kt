package id.co.moviebox.service_genre.data.api.service

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.base_component.model.ResultDto
import id.co.moviebox.service_genre.data.api.dto.DetailUserDto
import id.co.moviebox.service_genre.data.api.dto.SearchUserDto
import id.co.moviebox.service_genre.data.api.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApi {
    @GET("users")
    suspend fun getUsers() : List<UserDto>

    @GET("users/{username}")
    suspend fun getUsersByUsername(@Path("username") idUser: String): DetailUserDto

    @GET("search/users")
    suspend fun searchUserByName(@Query("q") query: String): ResultDto<SearchUserDto>

    @GET("search/users")
    suspend fun searchUserByName(@Query("q") query: String, @Query("page")index: Int): ResultDto<SearchUserDto>

    @GET("user_favorites")
    fun getUserFavorites(): Result<Any>
}