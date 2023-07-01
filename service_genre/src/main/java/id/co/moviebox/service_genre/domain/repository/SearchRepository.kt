package id.co.moviebox.service_genre.domain.repository

import androidx.paging.PagingData
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.SearchUser
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getMoviesByGenre(name: String): Flow<PagingData<MovieDto>>
}