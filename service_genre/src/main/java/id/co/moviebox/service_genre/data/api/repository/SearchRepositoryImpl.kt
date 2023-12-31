package id.co.moviebox.service_genre.data.api.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.data.api.flow.ShowSearchUserSource
import id.co.moviebox.service_genre.domain.entity.SearchUser
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(
    private val userSearchUserSource: ShowSearchUserSource
) : SearchRepository {

    override fun getMoviesByGenre(genreID: String): Flow<PagingData<MovieDto>> {
        userSearchUserSource.setQuery(genreID)
        return Pager(
            config = PagingConfig(
                pageSize = SHOWS_PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { userSearchUserSource }
        ).flow
    }

    companion object {
        const val SHOWS_PAGE_SIZE = 20
    }
}