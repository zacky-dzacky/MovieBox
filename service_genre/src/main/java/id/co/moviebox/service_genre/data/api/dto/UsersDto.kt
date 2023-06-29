package id.co.moviebox.service_genre.data.api.dto

import java.io.Serializable

data class UsersDto(
    val site_admin: List<UserDto>,
) : Serializable {
    companion object {
        val DEFAULT_LIST = listOf<UserDto>()
    }
}