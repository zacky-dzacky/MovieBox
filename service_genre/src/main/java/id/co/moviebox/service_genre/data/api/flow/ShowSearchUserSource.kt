package id.co.moviebox.service_genre.data.api.flow

import androidx.paging.PagingSource
import androidx.paging.PagingState
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.data.api.mapper.MoviesByGenreMapper
import id.co.moviebox.service_genre.data.api.service.MoviesApi
import retrofit2.HttpException
import java.io.IOException

class ShowSearchUserSource(
    private val userApi: MoviesApi,
    private val moviesByGenreMapper: MoviesByGenreMapper
) : PagingSource<Int, MovieDto>(){

    private lateinit var query: String

    companion object {
        const val SHOWS_STARTING_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, MovieDto>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieDto> {
        val position = params.key ?: SHOWS_STARTING_INDEX
        return try {
            val showsList = userApi.getMoviesByGenre(query, position)
            val data = moviesByGenreMapper(showsList)
            LoadResult.Page(
                data = data ?: listOf(),
                prevKey = if (position == SHOWS_STARTING_INDEX) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    fun setQuery(query: String) {
        this.query = query
    }
}