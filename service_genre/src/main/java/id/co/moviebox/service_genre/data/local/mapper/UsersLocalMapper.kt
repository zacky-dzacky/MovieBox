package id.co.moviebox.service_genre.data.local.mapper

import id.co.moviebox.service_genre.data.local.entity.UserLocal
import id.co.moviebox.service_genre.domain.entity.Genre

class UsersLocalMapper {
    operator fun invoke(from: List<UserLocal>): List<Genre> {
        return from.map {
            val data = it
            Genre(
                id = data.id,
                name = "name"
            )
        }
    }
}