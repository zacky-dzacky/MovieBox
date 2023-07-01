package id.co.moviebox.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.data.api.dto.MovieDto
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.repository.SearchRepository
import id.co.moviebox.service_genre.domain.usecase.GetFavoriteUseCase
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase,
    getFavoriteUseCase: GetFavoriteUseCase,
    private val searchRepository: SearchRepository
): ViewModel() {

    val getGenres = StatefulLiveData(
        getUsersUseCase,
        viewModelScope,
        true
    )

    val getFavoriteUsers = StatefulLiveData(
        getFavoriteUseCase,
        viewModelScope,
        true
    )

    fun getUsers() {
        getGenres.get(GetUserReq.DEFAULT)
    }

    fun getFavoriteUsers() {
        getFavoriteUsers.get(Unit)
    }

    fun getMoviesByGenre(data: String): Flow<PagingData<MovieDto>> {
        return searchRepository.getMoviesByGenre(data)
            .cachedIn(viewModelScope)
    }
}