package id.co.moviebox.feature_search.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.SearchUser
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchRepository
): ViewModel(){


    fun searchUserByQuery(query: String): Flow<PagingData<MovieDto>> {
        return searchUseCase.getMoviesByGenre(query)
            .cachedIn(viewModelScope)
    }
}