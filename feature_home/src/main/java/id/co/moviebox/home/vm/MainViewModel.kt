package id.co.moviebox.home.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.co.moviebox.base_component.extention.StatefulLiveData
import id.co.moviebox.service_genre.domain.entity.GetUserReq
import id.co.moviebox.service_genre.domain.usecase.GetFavoriteUseCase
import id.co.moviebox.service_genre.domain.usecase.GetUsersUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    getUsersUseCase: GetUsersUseCase,
    getFavoriteUseCase: GetFavoriteUseCase
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
}