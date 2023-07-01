package id.co.moviebox.service_genre.data.api.mapper

import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.data.api.dto.MoviesByGenreDto

class MoviesByGenreMapper {
    operator fun invoke(from: MoviesByGenreDto?): List<MovieDto> {
        return from?.result?.map {
            val data = it
            MovieDto(
                description = data.description,
                favorite_count = data.favorite_count,
                id = data.id,
                item_count = data.item_count,
                iso_639_1 = data.iso_639_1,
                list_type = data.list_type,
                name = data.name,
                poster_path = data.poster_path
            )
        } ?: listOf()
    }
}