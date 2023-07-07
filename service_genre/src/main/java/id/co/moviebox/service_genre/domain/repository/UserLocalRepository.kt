package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.base_component.model.Result
import id.co.moviebox.service_genre.domain.entity.DetailMovie
import id.co.moviebox.service_genre.domain.entity.Genre

interface UserLocalRepository {
    suspend fun getTrending(): List<Genre>
    suspend fun setFavoriteUser(userID: Genre): Result<Unit>
    suspend fun unSetFavoriteUser(userID: Genre): Result<Unit>
    suspend fun getDetailUser(userID: String): Result<DetailMovie>
}