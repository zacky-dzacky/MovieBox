package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.Genre

interface UserLocalRepository {
    suspend fun getAllFavoriteUser(): List<Genre>
    suspend fun setFavoriteUser(userID: Genre): Result<Unit>
    suspend fun unSetFavoriteUser(userID: Genre): Result<Unit>
    suspend fun getDetailUser(userID: String): Result<DetailUser>
}