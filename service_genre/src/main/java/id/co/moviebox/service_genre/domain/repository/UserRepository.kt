package id.co.moviebox.service_genre.domain.repository

import id.co.moviebox.service_genre.domain.entity.DetailUser
import id.co.moviebox.service_genre.domain.entity.User

interface UserRepository {
    suspend fun getListUser(): List<User>
    suspend fun getUser(username: String): DetailUser
}