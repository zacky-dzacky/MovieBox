package id.co.moviebox.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import id.co.moviebox.service_genre.domain.usecase.GetTrendingUseCase
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase,
    getTrendingUseCase: GetTrendingUseCase,
    private val searchRepository: SearchRepository
): ViewModel() {

    val getGenres = StatefulLiveData(
        getUsersUseCase,
        viewModelScope,
        true
    )

    val getTrending = StatefulLiveData(
        getTrendingUseCase,
        viewModelScope,
        true
    )

    fun getUsers() {
        getGenres.get(GetUserReq.DEFAULT)
    }

    fun getTrending() {
        getTrending.get(Unit)
    }

    fun getMoviesByGenre(data: String): Flow<PagingData<MovieDto>> {
        return searchRepository.getMoviesByGenre(data)
            .cachedIn(viewModelScope)
    }
}