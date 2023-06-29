package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.User

interface UserLocalRepository {
    suspend fun getAllFavoriteUser(): List<User>
    suspend fun setFavoriteUser(userID: User): Result<Unit>
    suspend fun unSetFavoriteUser(userID: User): Result<Unit>
    suspend fun getDetailUser(userID: String): Result<DetailUser>
}