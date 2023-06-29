package id.co.moviebox.service_genre.data.api.mapper

import id.co.moviebox.service_genre.data.api.dto.GenreDto
import id.co.moviebox.service_genre.domain.entity.Genre

class GenresDtoMapper {
    operator fun invoke(from: List<GenreDto>): List<Genre> {
        return from.map {
            val data = it
            Genre(
                id = data.id,
                name = data.name

            )
        } ?: listOf()
    }
}